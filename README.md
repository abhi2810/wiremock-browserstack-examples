Network Record and Playback using WireMock with BrowserStack Local
----

#Introduction
* Run `WireMockRecordAndPlayback.java` file.
* Start BrowserStack Local Binary.
```shell
./BrowserStackLocal --key <BROWSERSTACK_ACCESS_KEY> --force-local --local-proxy-host localhost --local-proxy-port 9999 --force-proxy
```
* Press 1 to start recording and enter base URL(eg: http://example.mocklab.io) to be recorded.
* Start a session on Browserstack Live or App-Live and perform actions.
* Press 2 to stop recording.
* Press 3 to close WireMock.
* Stubbing is stored in `src/test/resources/mappings` for each endpoint in json format after recording is stopped.