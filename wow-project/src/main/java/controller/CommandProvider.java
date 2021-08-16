package controller;

import java.util.HashMap;
import java.util.Map;

import controllerCommandMethods.GoToAuthorizationPage;
import controllerCommandMethods.GoToAddNewsPage;
import controllerCommandMethods.GoToMainPage;
import controllerCommandMethods.GoToRegistrationPage;
import controllerCommandMethods.RegistrationNewUser;
import controllerCommandMethods.UnknownCommand;
import controllerCommandMethods.AddNews;
import controllerCommandMethods.AuthorizationUser;
import controllerCommandMethods.ChangeLocal;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.AUTHORIZATION_PAGE, new GoToAuthorizationPage());
		commands.put(CommandName.REGISTRATION_PAGE, new GoToRegistrationPage());
		commands.put(CommandName.REGISTRATION_NEW_USER, new RegistrationNewUser());
		commands.put(CommandName.AUTHORIZATION_USER, new AuthorizationUser());
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandName.ADD_NEWS, new AddNews());
		commands.put(CommandName.ADD_NEWS_PAGE, new GoToAddNewsPage());
		commands.put(CommandName.CHANGE_LOCAL, new ChangeLocal());
		commands.put(CommandName.UNKNOWN_COMMAND, new UnknownCommand());
	}

	public Command findCommand(String name) {
		if (name == null) {
			name = CommandName.UNKNOWN_COMMAND.toString();
		}

		CommandName commandName;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
		} catch (IllegalArgumentException e) { // logging
			commandName = CommandName.UNKNOWN_COMMAND;
		}

		Command command = commands.get(commandName);
		return command;
	}

}
