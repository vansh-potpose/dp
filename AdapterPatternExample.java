// Old Media Player that only supports MP3
class MP3Player {
    public String playMP3(String fileName) {
        return "Playing MP3 file: " + fileName;
    }
}

// New Media Player that supports MP4
class MP4Player {
    public String playMP4(String fileName) {
        return "Playing MP4 file: " + fileName;
    }
}

// Adapter to make MP4Player compatible with MP3Player
class MediaAdapter extends MP3Player {
    private MP4Player mp4Player;

    public MediaAdapter(MP4Player mp4Player) {
        this.mp4Player = mp4Player;
    }

    @Override
    public String playMP3(String fileName) {
        return mp4Player.playMP4(fileName);
    }
}

// Main class to test the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Old MP3 player usage
        MP3Player mp3Player = new MP3Player();
        System.out.println(mp3Player.playMP3("song.mp3"));

        // Using the adapter to play MP4 files
        MP4Player mp4Player = new MP4Player();
        MediaAdapter adapter = new MediaAdapter(mp4Player);
        System.out.println(adapter.playMP3("video.mp4"));
    }
}
