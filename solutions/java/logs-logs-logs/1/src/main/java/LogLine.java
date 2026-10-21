public class LogLine {
    private String logLine;
    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String abreviatura = this.logLine.substring(1, 4);
        switch (abreviatura) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        LogLevel nivel = this.getLogLevel();
        int codigo = nivel.getNumeroCorto();
        String mensaje = this.logLine.substring(7);
        return codigo + ":" + mensaje;
    }
}
