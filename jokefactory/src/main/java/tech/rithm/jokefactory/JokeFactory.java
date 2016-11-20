package tech.rithm.jokefactory;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class JokeFactory {

    private final static String[] jokes = new String[] {
            "Did you hear about the guy whose whole left side was cut off? He's all right now.",
            "I'd tell you a chemistry joke but I know I wouldn't get a reaction.",
            "I wasn't originally going to get a brain transplant, but then I changed my mind.",
            "I wondered why the baseball was getting bigger. Then it hit me.",
            "A friend of mine tried to annoy me with bird puns, but I soon realized that toucan play at that game.",
            "Yesterday I accidentally swallowed some food coloring. The doctor says I'm OK, but I feel like I've dyed a little inside.",
            "Did you hear about the guy who got hit in the head with a can of soda? He was lucky it was a soft drink.",
            "I'm reading a book about anti-gravity. It's impossible to put down.",
            "Have you ever tried to eat a clock? It's very time consuming.",
            "If there was someone selling drugs in this place, weed know.",
            "It's not that the man did not know how to juggle, he just didn't have the balls to do it.",
            "The experienced carpenter really nailed it, but the new guy screwed everything up.",
            "A new type of broom came out, it is sweeping the nation.",
            "I used to be a banker but I lost interest.",
            "He drove his expensive car into a tree and found out how the Mercedes bends.",
            "A prisoner's favorite punctuation mark is the period. It marks the end of his sentence.",
            "When William joined the army he disliked the phrase 'fire at will'.",
            "Show me a piano falling down a mineshaft and I'll show you A-flat minor.",
            "The shoemaker did not deny his apprentice anything he needed. He gave his awl.",
            "I couldn't quite remember how to throw a boomerang, but eventually it came back to me.",
            "Claustrophobic people are more productive thinking outside the box.",
            "A man just assaulted me with milk, cream and butter. How dairy.",
            "What is the difference between a nicely dressed man on a tricycle and a poorly dressed man on a bicycle? A tire.",
            "The one who invented the door knocker got a No-bell prize.",
            "I'm glad I know sign language, it's pretty handy.",
            "I relish the fact that you've mustard the strength to ketchup to me.",
            "I don't trust these stairs because they're always up to something.",
            "Need an ark to save two of every animal? I noah guy.",
            "There was once a cross-eyed teacher who couldn't control his pupils.",
            "When notes get in treble, bass-ically they get put behind bars. The alto-nate punishment is to push them off a clef and hope they land flat on sharp objects.",
            "So what if I don't know what apocalypse means!? It's not the end of the world!",
            "Police were called to a daycare where a three-year-old was resisting a rest.",
            "When Peter Pan punches, they Neverland.",
            "A bicycle can't stand on its own because it is two-tired.",
            "My friend's bakery burned down last night. Now his business is toast.",
            "I once heard a joke about amnesia, but I forgot how it goes.",
    };

    public JokeFactory(){



    }

    public static String getRandomJoke(){

        Random random = new Random();
        int randomJoke = random.nextInt(jokes.length + 1);

        return jokes[randomJoke];
    }


}
