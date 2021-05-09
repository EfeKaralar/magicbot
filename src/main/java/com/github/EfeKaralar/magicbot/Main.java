package com.github.EfeKaralar.magicbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;

import java.lang.Math;

public class Main {

	public static void main(String[] args) {
		
		String token = "ODQwOTE5NzU3NTQ0MDk1NzQ0.YJfNjQ.tmSnw6j0mFlRh1rwT1JaTb4rexc";
		
		// list of the videos. Only the part after "https://youtu.be/"
		String magicVideos[] = 
			{"kumlnXLJLLk?t=71",
			"w4iu5FMaR2o",
			"3zv1mha4wCw?t=3",
			"kjURsDCIJws?t=72",
			"EAN-PwRfJcA?t=48",
			"y4U-kHdXgz0",
			"Z8Ws4PEky28"
		};

		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		System.out.println(api.createBotInvite());

        // Add a listener which sends a random magic trick video from a list of videos if someone writes "!ping"
        ListenerManager<MessageCreateListener> listenermanager =  api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!magica")) {
            	
            	String link = getVideo(magicVideos);
                event.getChannel().sendMessage("Here's a magic trick for you " + 
            	event.getMessageAuthor().getDisplayName() +
                		"!\n\n"+"https://youtu.be/"+link);
            }
            else if (event.getMessageContent().equalsIgnoreCase("!magic_bot_baldoya_cevap_ver_bakim")) {
            	event.getChannel().sendMessage("Here's a magic trick for you Baldo!\n\n"+"https://youtu.be/G4fgh2HO4BM");
            }
        });
        listenermanager.remove();
	}

	public static String getVideo(String[] videos) {
		// get a random video from the specified list.
		int randomIndex = Math.round(Math.round(Math.random()*(videos.length-1)));
		System.out.println(randomIndex);
		System.out.println(videos[randomIndex]);
		return videos[randomIndex];
	}

}
