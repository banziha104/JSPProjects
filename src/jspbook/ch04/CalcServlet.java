package jspbook.ch04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalcServlet", urlPatterns = {"/CalcServlet"})
public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1, num2;
        int result;
        String op;

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        num1 = Integer.parseInt(request.getParameter("num1"));
        num2 = Integer.parseInt(request.getParameter("num2"));
        op = request.getParameter("operator");
        result = calc(num1,num2,op);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>계산기</TITLE></HEAD>");
        out.println("<BODY><center>");
        out.println("<H2>계산결과<H2>");
        out.println("<HR>");
        out.println(num1+" "+ op + " "+ num2 + " = " +result);
        out.println("</BODY></HEAD>");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public int calc(int a, int b, String op){
        int result = 0;

        switch (op){
            case "+" :
                result = a + b;
                break;
            case "-" :
                result = a - b;
                break;
            case "/" :
                result = a / b;
                break;
            case "*" :
                result = a * b;
                break;

        }
        return result;
    }
}
