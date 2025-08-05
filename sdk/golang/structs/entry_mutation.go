package structs

import "time"

type MutationType string

const (
	Create     MutationType = "create"
	Update                  = "update"
	Delete                  = "delete"
	SoftDelete              = "soft_delete"
)

type EntryMutation struct {
	Type      MutationType `json:"type"`
	Data      any          `json:"data"`
	ExpiredAt *time.Time   `json:"expired_at"`
	DeletedAt *time.Time   `json:"deleted_at"`
}
