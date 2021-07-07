package controller;

import jakarta.servlet.RequestDispatcher;
import bean.RegistrationInfo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_TO_CONTROLLER = "commandToController";
	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String commandName = request.getParameter(COMMAND_TO_CONTROLLER);
		Command command = provider.findCommand(commandName);
		command.execute(request, response);

	}

}
