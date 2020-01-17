package gg.warcraft.chat.app.message;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import gg.warcraft.chat.api.channel.Channel;
import gg.warcraft.chat.api.message.Message;
import gg.warcraft.monolith.api.core.command.CommandSender;
import gg.warcraft.monolith.api.core.command.ConsoleCommandSender$;
import gg.warcraft.monolith.api.util.ColorCode;

public class ServerMessage implements Message {
    private final CommandSender sender;
    private final String originalText;
    private final String formattedText;

    @Inject
    public ServerMessage(@Assisted String text) {
        this.sender = ConsoleCommandSender$.MODULE$;
        this.originalText = text;
        this.formattedText = String.format("%s[SERVER] %s", ColorCode.YELLOW, text);
    }

    @Override
    public Channel getChannel() {
        return null;
    }

    @Override
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public String getOriginal() {
        return originalText;
    }

    @Override
    public String getFormatted() {
        return formattedText;
    }
}
