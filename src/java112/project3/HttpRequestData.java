package java112.project3;


import java.util.Locale;


/**
 * The HttpRequestData class is a JavaBean for the project 3 web application.
 * It will contain all the instance variables and getters/setters for the
 * HttpRequestServlet.
 *
 * @author Corissa Engel
 */
public class HttpRequestData {

    private String remoteComputer;
    private String remoteAddress;
    private String httpMethod;
    private String requestUri;
    private StringBuffer requestUrl;
    private String requestProtocal;
    private String serverName;
    private int serverPortNmb;
    private Locale currentServerLocale;
    private String query;
    private String queryParameter;
    private String userAgent;


    /**
     * Empty constructor for HttpRequestData JavaBean
     */
    public HttpRequestData() {
    // currentServerLocale = "default value";
    }


    /**
     * Returns the value of remoteComputer.
     * @return remoteComputer The remote computer making the request.
     */
    public String getRemoteComputer() {
        return remoteComputer;
    }


    /**
     * Sets the value of remoteComputer.
     * @param remoteComputer The value to assign remoteComputer.
     */
    public void setRemoteComputer(String remoteComputer) {
        this.remoteComputer = remoteComputer;
    }


    /**
     * Returns the value of remoteAddress.
     * @return The address of the remote computer making the request.
     */
    public String getRemoteAddress() {
        return remoteAddress;
    }


    /**
     * Sets the value of remoteAddress.
     * @param remoteAddress The value to assign remoteAddress.
     */
    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }


    /**
     * Returns the value of httpMethod.
     * @return httpMethod The HTTP method of the request.
     */
    public String getHttpMethod() {
        return httpMethod;
    }


    /**
     * Sets the value of httpMethod.
     * @param httpMethod The value to assign httpMethod.
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }


    /**
     * Returns the value of requestUri.
     * @return requestUri The request URI.
     */
    public String getRequestUri() {
        return requestUri;
    }


    /**
     * Sets the value of requestUri.
     * @param requestUri The value to assign requestUri.
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }


    /**
     * Returns the value of requestUrl.
     * @requestUrl The request URL.
     */
    public StringBuffer getRequestUrl() {
        return requestUrl;
    }


    /**
     * Sets the value of requestUrl.
     * @param requestUrl The value to assign requestUrl.
     */
    public void setRequestUrl(StringBuffer requestUrl) {
        this.requestUrl = requestUrl;
    }


    /**
     * Returns the value of requestProtocal.
     * @return requestProtocal The protocol of the request.
     */
    public String getRequestProtocal() {
        return requestProtocal;
    }


    /**
     * Sets the value of requestProtocal.
     * @param requestProtocal The value to assign requestProtocal.
     */
    public void setRequestProtocal(String requestProtocal) {
        this.requestProtocal = requestProtocal;
    }


    /**
     * Returns the value of serverName.
     * @return serverName The request server name.
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the value of serverName.
     * @param serverName The value to assign serverName.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Returns the value of serverPortNmb.
     * @return serverPortNmb The server port number.
     */
    public int getServerPortNmb() {
        return serverPortNmb;
    }


    /**
     * Sets the value of serverPortNmb.
     * @param serverPortNmb The value to assign serverPortNmb.
     */
    public void setServerPortNmb(int serverPortNmb) {
        this.serverPortNmb = serverPortNmb;
    }


    /**
     * Returns the value of currentServerLocale.
     * @return currentServerLocale The current Locale of the server.
     */
    public Locale getCurrentServerLocale() {
        return currentServerLocale;
    }


    /**
     * Sets the value of currentServerLocale.
     * @param currentServerLocale The value to assign currentServerLocale.
     */
    public void setCurrentServerLocale(Locale currentServerLocale) {
        this.currentServerLocale = currentServerLocale;
    }


    /**
     * Returns the value of query.
     * @return query The query string.
     */
    public String getQuery() {
        return query;
    }


    /**
     * Sets the value of query.
     * @param query The value to assign query.
     */
    public void setQuery(String query) {
        this.query = query;
    }


    /**
     * Returns the value of queryParameter.
     * @return queryParameter The value of the query parameter.
     */
    public String getQueryParameter() {
        return queryParameter;
    }


    /**
     * Sets the value of queryParameter.
     * @param queryParameter The value to assign queryParameter.
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }


    /**
     * Returns the value of userAgent.
     * @return userAgent The value of the request header.
     */
    public String getUserAgent() {
        return userAgent;
    }


    /**
     * Sets the value of userAgent.
     * @param userAgent The value to assign userAgent.
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
