package com.study.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestController extends HttpServlet {

	// url, 컨트롤러 정보를 보관할 맵
	private Map<String, IController> handlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try (FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				IController controller = (IController) handlerClass.newInstance();
				handlerMap.put(command, controller); // 맵에 저장
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println(command + "를 로드하지 못했슴다" + e.getMessage());
			}
		} // while
	}

	@Override
	// 1. 사용자의 요청을 받음
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 2. 사용자 요청분석
		// --파라미터 : /member?type=list, /member?type=view
		// --요청 uri : /member/list , /member/view
		String uri = request.getRequestURI();
		// /study/member/memberList.do
		uri = uri.substring(request.getContextPath().length());

		String viewPage = null;
		IController controller = null;

		// // 3. 모델을 사용해서 기능 수행
		// // 4. 결과를 속성에 저장 (request, session)
		// if (uri.contains("/member/memberList.do")) {
		// controller = new MemberListController();
		// } else if (uri.equals("/member/memberView.do")) {
		// controller = new MemberViewController();
		// } else if (uri.equals("/member/memberEdit.do")) {
		// controller = new MemberEditController();
		// } else {
		// throw new ServletException("지금은 memberList 만....");
		// }

		if (handlerMap.containsKey(uri)) {
			controller = handlerMap.get(uri);
			if (controller != null) {
				viewPage = controller.process(request, response);

				// viewPage 가 널 이거나, 리다이렉트는 어떻게 처리?

				// 5. 알맞은 뷰로 포워드
				//
				//
				if (viewPage != null) {

					if (viewPage.startsWith("redirect:")) {
						response.sendRedirect(request.getContextPath() + viewPage.substring(9));
					} else {
						// 해당 뷰로 포워드
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
						dispatcher.forward(request, response);
					}
				}
			} else {
				// 컨트롤러가 null인 경우
				throw new ServletException(uri + "컨트롤러가 없습니다.");

			}
		} else {
			// 요청 uri가 없으므로 404 예외 던짐
			response.setStatus(response.SC_NOT_FOUND, "없습니다.");
		}
	}

}
