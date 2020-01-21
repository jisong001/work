package tt.login;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginUrl {//extends HttpServlet 

    /**
    * 代理请求数据
    * 代理地址 http://127.0.0.1:8080/Test/servlet/
    *
    *   接口 TestOne
    *       参数 Time （String）
    *
    *   接口 TestTow
    *       接口 Code （String）
    *
    */
//    public void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String base="http://127.0.0.1:8080/Test/servlet/";
//
//        String url=request.getParameter("url");
//        System.out.println(url);
//
//        //第一次请求
//        if("TestOne".equals(url)){
//            String time=request.getParameter("Time");
//
//            Map<String,String>  param= new HashMap<String, String>(); 
//            param.put("Time", time);
//
//            try {
//                //请求图片
//                response.setContentType("image/jpeg");
//                OutputStream out = response.getOutputStream();
//                out.write(UrlLib.doGet(request, base+url, param));
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        //第二次请求
//        }else if("TestTow".equals(url)){
//            String code=request.getParameter("Code");
//            Map<String,String>  param= new HashMap<String, String>(); 
//            param.put("Code", code);
//
//            try{
//                //请求文字
//                response.setContentType("text/html");
//                PrintWriter out = response.getWriter();
//                out.print(new String(UrlLib.doPost(request, base+url, param),"UTF-8"));
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else{
//            //参数错误
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.print("参数错误");
//            out.flush();
//            out.close();
//        }
//    }

}