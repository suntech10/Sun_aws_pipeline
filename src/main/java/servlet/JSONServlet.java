package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.stream.Collectors;

@WebServlet(value = "/hello")
public class JSONServlet<ObjectMapper> extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Content-Type", "application/json");
        resp.setStatus(200);
        resp.getOutputStream().println("{\"username\":\"pinkerton\",\"password\":\"1234\",\"object\":{\"key\":\"value\"}}");
        // resp.getOutputStream().println("https://github.com/211025-Enterprise/worm_p1/blob/main/src/main/java/services/dao.javav");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // implement me
        // I should take information in JSON format out of the request body and print it to the java console.
        Enumeration<String> headers = req.getHeaderNames();
        System.out.println("headers.hasMoreElements()");
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.printf("%s : %s\n", header, req.getHeader(header));
        }
        System.out.println("all headers printed");

        Enumeration<String> parameters = req.getParameterNames();
        while (parameters.hasMoreElements()) {
            String parameter = parameters.nextElement();
            System.out.printf("%s : %s\n", parameter, req.getParameter(parameter));
        }

        String collectorBody = req.getReader().lines().collect(Collectors.joining("\n"));
        String json = collectorBody;

        System.out.println("Collector Body: ");
        System.out.println(collectorBody);

    /*         req.setHeader("Content-Type", "application/json");
            Enumeration<String>
            req.setStatus(400);
            req.getOutputStream().println("\"-forwarded-proto\": \"https\"");*/

        // Parse the json string into a java object


        //       ObjectMapper mapper = (ObjectMapper) new Object();
        // ObjectMapper mapper = (ObjectMapper) new ObjectMapper();
//Cat cat = null;
        // Cat cat = mapper.readValue(json, cat.Class);

        //System.out.println(cat);


    }

    JSONServlet jssv = new JSONServlet();


    // HttpServletRequest req = new HttpServletRequest() {
    public String getHeader(String s) {
        return "hello there";
    }


    public void login(String s, String s1) throws ServletException {

    }


    public void logout() throws ServletException {

    }


    public String getParameter(String s) {
        return null;
    }


    public Enumeration<String> getParameterNames() {
        return null;
    }


    public String[] getParameterValues(String s) {
        return new String[0];
    }


    public String getProtocol() {
        return null;
    }


    public String getScheme() {
        return null;
    }


    public int getLocalPort() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    // req.getHeader("header");
    // try {
    //        jssv.doPost(req, resp);
    // } catch (IOException ie) {
    //     ie.printStackTrace();
    // }
}


