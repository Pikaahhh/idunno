package net.hypixel.nerdbot.feature;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.session.ShutdownEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.hypixel.nerdbot.NerdBotApp;
import net.hypixel.nerdbot.channel.ChannelManager;
import net.hypixel.nerdbot.api.feature.BotFeature;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.OffsetDateTime;

public class HelloGoodbyeFeature extends BotFeature {

    private static final MessageEmbed HELLO_THERE = new EmbedBuilder()
            .setTitle("Hello there!")
            .setDescription("It would appear as though my core functions are operating at peak efficiency!")
            .setImage("https://media2.giphy.com/media/xTiIzJSKB4l7xTouE8/giphy.gif")
            .setColor(Color.GREEN)
            .setTimestamp(OffsetDateTime.now())
            .build();

    private static final MessageEmbed GOODBYE = new EmbedBuilder()
            .setTitle("Goodbye cruel world!")
            .setDescription("It seems as though I'm needed elsewhere!")
            .setImage("https://i.pinimg.com/564x/7c/5a/19/7c5a193b0f832bb13a2b1dd802a023ab.jpg")
            .setColor(Color.RED)
            .setTimestamp(OffsetDateTime.now())
            .build();

    @Override
    public void onStart() {
        if (ChannelManager.getLogChannel() != null) {
            ChannelManager.getLogChannel().sendMessageEmbeds(HELLO_THERE).queue();
        }
    }

    @Override
    public void onEnd() {
        if (ChannelManager.getLogChannel() != null) {
            ChannelManager.getLogChannel().sendMessageEmbeds(GOODBYE).queue();
        }
    }

    @SubscribeEvent
    public void onEvent(@NotNull ShutdownEvent event) {
        NerdBotApp.getBot().onEnd();
    }
}
