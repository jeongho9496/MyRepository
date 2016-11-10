package com.wiredfactory.bluewave.interfaces;

public interface IDialogListener {
	public static final int CALLBACK_MACRO_TOGGLE = 1;
	public static final int CALLBACK_MACRO_EDIT = 2;
	public static final int CALLBACK_MACRO_DELETE = 3;
	public static final int CALLBACK_MACRO_LAYOUT_EDIT = 11;
	
	public static final int CALLBACK_BEACON_MAKE_UUID = 101;	// Make a macro using UUID 
	public static final int CALLBACK_BEACON_MAKE_MAJOR = 102;	// Make a macro using Major/Minor
	public static final int CALLBACK_BEACON_MAKE_MACRO = 103;	// Make a macro using UUID/Major/Minor
	public static final int CALLBACK_BEACON_FORM_DIALOG = 104;	// Show beacon name dialog
	public static final int CALLBACK_INSERT_EDIT_BEACON = 105;	// Insert/Update beacon info
	public static final int CALLBACK_DELETE_BEACON = 106;	// Delete beacon info
	
	public static final int CALLBACK_CLOSE = 1000;
	
	public void OnDialogCallback(int msgType, int arg0, int arg1, String arg2, String arg3, Object arg4);
}
