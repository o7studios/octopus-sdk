package octopus

import (
	"crypto/tls"
	"crypto/x509"
	"errors"
	"fmt"
	"os"
	"strconv"

	apiv1 "github.com/o7studios/octopus-sdk/sdk/golang/gen/api/v1"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials"
)

type SDK struct {
	conn *grpc.ClientConn
	apiv1.OctopusClient
}

func NewByEnv() (*SDK, error) {
	host := os.Getenv("OCTOPUS_HOST")
	if host == "" {
		return nil, fmt.Errorf("environment variable `OCTOPUS_HOST` not set for octopus connection")
	}
	portString := os.Getenv("OCTOPUS_PORT")
	if portString == "" {
		return nil, fmt.Errorf("environment variable `OCTOPUS_PORT` not set for octopus connection")
	}

	port, err := strconv.Atoi(portString)
	if err != nil {
		return nil, fmt.Errorf("environment variable `OCTOPUS_PORT` must be an short int")
	}
	return New(host, port)
}

func New(host string, port int) (*SDK, error) {
	target := fmt.Sprintf("%s:%d", host, port)

	var conn *grpc.ClientConn

	if os.Getenv("OCTOPUS_ENVIRONMENT") != "dev" {
		requiredEnvs := []string{"OCTOPUS_CLIENT_CERT", "OCTOPUS_CLIENT_KEY", "OCTOPUS_CA_CERT"}
		for _, env := range requiredEnvs {
			if os.Getenv(env) == "" {
				return nil, fmt.Errorf("environment variable `%s` must be set in non-dev environments for security reasons", env)
			}
		}

		clientCertPEM := []byte(os.Getenv("OCTOPUS_CLIENT_CERT"))
		clientKeyPEM := []byte(os.Getenv("OCTOPUS_CLIENT_KEY"))
		caCertPEM := []byte(os.Getenv("OCTOPUS_CA_CERT"))

		clientCert, err := tls.X509KeyPair(clientCertPEM, clientKeyPEM)
		if err != nil {
			return nil, err
		}

		caCertPool := x509.NewCertPool()
		if ok := caCertPool.AppendCertsFromPEM(caCertPEM); !ok {
			return nil, errors.New("failed to append ca cert pem")
		}

		tlsConfig := &tls.Config{
			Certificates: []tls.Certificate{clientCert},
			RootCAs:      caCertPool,
		}

		if connection, err := grpc.NewClient(
			target,
			grpc.WithTransportCredentials(credentials.NewTLS(tlsConfig)),
		); err == nil {
			conn = connection
		} else {
			return nil, err
		}
	} else {
		if connection, err := grpc.NewClient(target); err == nil {
			conn = connection
		} else {
			return nil, err
		}
	}

	return &SDK{
		conn:          conn,
		OctopusClient: apiv1.NewOctopusClient(conn),
	}, nil
}

func (sdk *SDK) Close() error {
	return sdk.conn.Close()
}
