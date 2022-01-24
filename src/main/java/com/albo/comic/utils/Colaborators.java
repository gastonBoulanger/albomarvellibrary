package com.albo.comic.utils;

public enum Colaborators {	
	EDITOR ("editor"),
	WRITER ("writer"),
	COLORIST ("colorist"),
	PARTNER ("partner");
	
	private final String name;
	
	private Colaborators(String s) {
        name = s;
    }
	
	public String toString() {
		return this.name;
	}
}
