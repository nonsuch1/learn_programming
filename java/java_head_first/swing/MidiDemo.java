import javax.sound.midi.*;

public class MidiDemo {
	public static void main(String[] args) {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for (int i = 5; i < 61; i += 4) {
				track.add(makeEvent(144, 1, i, 100, i));
				track.add(makeEvent(128, 1, i, 100, i + 2));
			}

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		/*
		ShortMessage a = new ShortMessage();
		a.setMessage(144, 1, note, 100);
		MidiEvent noteOn = new MidiEvent(a, 1);
		track.add(noteOn);

		ShortMessage b = new ShortMessage();
		b.setMessage(128, 1, note, 100);
		MidiEvent noteOff = new MidiEvent(b, 16);
		track.add(noteOff);
		*/
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
}
