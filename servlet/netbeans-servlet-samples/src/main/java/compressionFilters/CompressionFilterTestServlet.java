
package compressionFilters;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import util.HTMLFilter;

/**
 * Very Simple test servlet to test compression filter
 * @author Amy Roh
 * @version $Revision$, $Date$
 */

public class CompressionFilterTestServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        ServletOutputStream out = response.getOutputStream();
        response.setContentType("text/plain");

        Enumeration e = ((HttpServletRequest)request).getHeaders("Accept-Encoding");
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            out.println( HTMLFilter.filter(name));
            if (name.indexOf("gzip") != -1) {
                out.println("gzip supported -- able to compress");
            }
            else {
                out.println("gzip not supported");
            }
        }


        out.println("Compression Filter Test Servlet");
        out.close();
    }

}
