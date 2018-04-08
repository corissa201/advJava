package java112.project3;


/**
 * @author Corissa Engel
 * The HttpRequestData class is a JavaBean for the project 3 web application.
 * It will contain all the instance variables and getters/setters for the
 * HttpRequestServlet.
 */
public class HttpRequestData {

    private String remoteComputer;
    private String remoteAddress;
    private String httpMethod;
    private String requestUri;
    private String requestUrl;
    private String requestProtocal;
    private String serverName;
    private String serverPortNmb;
    private String currentServerLocale;
    private String query;
    private String queryParameter;
    private String User-Agent;


    /**
     * Empty constructor for HttpRequestData JavaBean
     */
    public HttpRequestData() {
    }


    /**
     * Returns the value of remoteComputer.
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
     */
    public String getRequestUrl() {
        return requestUrl;
    }


    /**
     * Sets the value of requestUrl.
     * @param requestUrl The value to assign requestUrl.
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    /**
     * Returns the value of requestProtocal.
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
     */
    public String getServerPortNmb() {
        return serverPortNmb;
    }


    /**
     * Sets the value of serverPortNmb.
     * @param serverPortNmb The value to assign serverPortNmb.
     */
    public void setServerPortNmb(String serverPortNmb) {
        this.serverPortNmb = serverPortNmb;
    }


    /**
     * Returns the value of currentServerLocale.
     */
    public String getCurrentServerLocale() {
        return currentServerLocale;
    }


    /**
     * Sets the value of currentServerLocale.
     * @param currentServerLocale The value to assign currentServerLocale.
     */
    public void setCurrentServerLocale(String currentServerLocale) {
        this.currentServerLocale = currentServerLocale;
    }


    /**
     * Returns the value of query.
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
     * Returns the value of User-Agent.
     */
    public String getUser-Agent() {
        return User-Agent;
    }


    /**
     * Sets the value of User-Agent.
     * @param User-Agent The value to assign User-Agent.
     */
    public void setUser-Agent(String User-Agent) {
        this.User-Agent = User-Agent;
    }
}

