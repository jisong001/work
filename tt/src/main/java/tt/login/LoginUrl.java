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
    * ������������
    * �����ַ http://127.0.0.1:8080/Test/servlet/
    *
    *   �ӿ� TestOne
    *       ���� Time ��String��
    *
    *   �ӿ� TestTow
    *       �ӿ� Code ��String��
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
//        //��һ������
//        if("TestOne".equals(url)){
//            String time=request.getParameter("Time");
//
//            Map<String,String>  param= new HashMap<String, String>(); 
//            param.put("Time", time);
//
//            try {
//                //����ͼƬ
//                response.setContentType("image/jpeg");
//                OutputStream out = response.getOutputStream();
//                out.write(UrlLib.doGet(request, base+url, param));
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        //�ڶ�������
//        }else if("TestTow".equals(url)){
//            String code=request.getParameter("Code");
//            Map<String,String>  param= new HashMap<String, String>(); 
//            param.put("Code", code);
//
//            try{
//                //��������
//                response.setContentType("text/html");
//                PrintWriter out = response.getWriter();
//                out.print(new String(UrlLib.doPost(request, base+url, param),"UTF-8"));
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else{
//            //��������
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.print("��������");
//            out.flush();
//            out.close();
//        }
//    }

}