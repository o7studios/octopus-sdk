<img width="1024" height="220" alt="image" src="https://github.com/user-attachments/assets/22d1ec29-1486-4704-8061-3b98c092da21" />

# Octopus API & SDKs

**API & SDKs for o7studios product Octopus**

- Uses [Protocol Buffers](https://protobuf.dev/) with [Buf](https://buf.build/)

## Development

Full development setup available as [Development Container](https://containers.dev/).
Please use it for being able to tell "It works on my machine".

**Docker is required to be installed on your machine!**

### IntelliJ IDEA

- Open IntelliJ (Welcome screen)
- Navigate to `Remote Development` - `Dev Containers`
- Press `New Dev Container`
- Select `From VCS Project`
- Select and connect with `Docker`
- Select `IntelliJ IDEA`
- Enter `Git Repository`: `https://github.com/o7studios/octopus-sdk`
- Select `Detection for devcontainer.json file` `Automatic`
- Press `Build Container and Continue`

### Development Container Issues

If you encounter an issue with setting up a development container, please
try to rebuild it first before opening a GitHub Issue. It's not uncommon
that some issues may fix themselves after a fresh container rebuild.
