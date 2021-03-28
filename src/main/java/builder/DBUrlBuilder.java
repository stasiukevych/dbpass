package builder;

public class DBUrlBuilder {
  public static String buildURL(String dbVendor, String dbName, int port, String host) {
    return String.format("jdbc:%s://%s:%d/%s", dbVendor, host, port, dbName);
  }
}
