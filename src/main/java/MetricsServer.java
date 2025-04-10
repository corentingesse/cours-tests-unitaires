import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

public class MetricsServer {
    private static final Counter requestsTotal = Counter.build()
        .name("http_requests_total")
        .help("Total HTTP requests")
        .register();
        
    private static final Gauge memoryUsage = Gauge.build()
        .name("memory_usage_bytes")
        .help("Current memory usage")
        .register();

    public static void start() throws Exception {
        // Pour ajouter les métriques système (CPU, mémoire, etc.)
        DefaultExports.initialize();

        // Démarre un serveur HTTP Prometheus sur le port 1234
        new HTTPServer(1234);
    }

    public static void incrementRequests() {
        requestsTotal.inc();
    }

    public static void setMemoryUsage(long bytes) {
        memoryUsage.set(bytes);
    }
}