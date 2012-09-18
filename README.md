Code and build to repro [boundary/ordasity issue #17](https://github.com/boundary/ordasity/issues/17).

See `example.log` for an example run. I run a local zk and trigger each session expiration by twiddling local firewall rules. The code tries to connect to a local zk at `localhost:2190`, so setup some local port forwardings (e.g. `2190 -> 2181`) and twiddle them off and back on with a brief delay in between (e.g. 5s) to simulate expired sessions. I can usually repro the hang in ~2-5 session expirations.

To build and run:
```
mvn package
./run
```