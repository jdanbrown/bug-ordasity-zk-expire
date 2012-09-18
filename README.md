Code and build to repro [boundary/ordasity issue #?]().

See `example.log` for an example run.

To build and run:
```
mvn package
./run
```

This will try to connect to a local zk at `localhost:2190` (not included here). To simulate expired sessions, create a firewall port forwarding (e.g. `2190 -> 2181`) and twiddle it off and back on with a brief delay in between (e.g. 5s).