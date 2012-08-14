package br.com.drawing.extension;

import br.com.drawing.events.ServerReadyEventHandler;

import com.smartfoxserver.v2.core.SFSEventType;
import com.smartfoxserver.v2.extensions.SFSExtension;

public class DrawingDroidExtension extends SFSExtension {

	@Override
	public void init() {
		addEventHandler(SFSEventType.BUDDY_ADD, ServerReadyEventHandler.class);
		trace("Extension iniciada com sucesso");
	}

}
