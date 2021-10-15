package co.yedam.apiData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SampleDataServlet2")
public class SampleDataServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SampleDataServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
//		   numberOfRow: 10,
//           pageNo: 2,
//           startDate: '20211001',
//           endDate: '20211010'
		String nor = request.getParameter("numberOfRow");
		String pn = request.getParameter("pageNo");
		String sd = request.getParameter("startDate");
		String ed = request.getParameter("endDate");
		
		
		String hostUrl = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=50&serviceKey=pwnpEih2pV0BOkxNaCb8%2Fd7lD1hOC1uRu8a%2BKzHnANJVgiCDXW2SFfJPz7z5XX4bZDqGUr5qe%2Ffy%2B9X2ahZZUQ%3D%3D";
//		hostUrl += "&pageNo="+pn;
//		hostUrl += "&numofRows="+nor;
//		hostUrl += "&startCreateDt="+sd;
//		hostUrl += "&endCreateDt="+ed;
		
		URL url = new URL(hostUrl);
		HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
		urlconn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
		String result = "", line = "";
		while((line = br.readLine())!= null) {
			result += line+"\n";
		}
		response.getWriter().println(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
