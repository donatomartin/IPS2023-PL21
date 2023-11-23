package ips2023pl21.ui.parts;

import javax.swing.JButton;

public class ValueButton<T> extends JButton {

	private static final long serialVersionUID = 1L;
	
	T value;
	
	public ValueButton(String text) {
		super(text);
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

}
