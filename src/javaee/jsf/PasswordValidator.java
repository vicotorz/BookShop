package javaee.jsf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//自定义验证器---验证密码部分
@FacesValidator("javaee.jsf.passwordValidator")
public class PasswordValidator implements Validator {
	private static final String PASSWORD_REGEX = "^([0-9a-zA-Z_]){8,32}";

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String password = (String) value;

		Pattern mask = null;
		mask = Pattern.compile(PASSWORD_REGEX);

		Matcher matcher = mask.matcher(password);

		// 如果不匹配，显示提示信息
		if (!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setSummary("invalid password!");
			message.setDetail("invalid password!   Number and Chars");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
