import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.recording.SnapshotRecordResult;

import java.util.Scanner;

public class WireMockRecordAndPlayback {

    public static void main(String[] args) {
        WireMockServer server = new WireMockServer(WireMockConfiguration
                .wireMockConfig().port(9999).enableBrowserProxying(true));
        server.start();
        System.out.println("Enter option:\n1. Start Recording\n2. Stop Recording\n3. Close WireMock");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (true) {
            try {
                switch (n) {
                    case 1:
                        System.out.println("Enter URL to be recorded:");
                        sc.nextLine();
                        String url = sc.nextLine();
                        server.startRecording(url);
                        break;
                    case 2:
                        SnapshotRecordResult recordedMappings = server.stopRecording();
                        recordedMappings.getStubMappings().forEach(map -> System.out.print(map.toString()));
                        break;
                    case 3:
                        if (server != null)
                            server.stop();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
            if (n == 3)
                break;
            n = sc.nextInt();
        }

    }
}
