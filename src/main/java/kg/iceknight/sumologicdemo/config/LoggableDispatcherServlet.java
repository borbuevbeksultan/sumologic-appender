package kg.iceknight.sumologicdemo.config;

import kg.iceknight.sumologicdemo.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggableDispatcherServlet extends DispatcherServlet {
    private LoggingService loggingService;

    @Autowired
    public void setLoggingService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }
    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            super.doDispatch(request, response);
        } catch (Exception e) { }
        finally {
            loggingService.log();
        }

    }
}
