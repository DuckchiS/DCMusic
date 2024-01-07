package com.music.c.java;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.Scanner;

//Todo:현재 피아노만 나오게 하는데 이제는 기타(어쿠어틱, 베이스)와 드럼 그리고 클라리넷 을 선택하게 끔 하도록 하기
public class Main {
    private static MidiChannel channel;

    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
        // MIDI 시스템 열기
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();

        // MIDI 채널 가져오기
        channel = synthesizer.getChannels()[0];

        // 프로그램 설정 (기본적으로 피아노 프로그램 사용)
        channel.programChange(0);

        // 사용자 입력 처리를 위한 Scanner 시작
        startInputScanner();

        // 프로그램 종료 대기
        while (true) {
            Thread.sleep(100);
        }
    }

    private static void startInputScanner() {
        System.out.println("Press keys on the keyboard to play MIDI notes.");
        System.out.println("Press 'q' to quit.");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String input = scanner.next();
                if (input.length() > 0) {
                    char key = input.charAt(0);
                    int note = mapKeyToMIDINote(key);
                    if (note != -1) {
                        channel.noteOn(note, 64);  // 노트 연주 (velocity는 예시로 64로 설정)
                    }
                }
            }
        }
    }

    private static int mapKeyToMIDINote(char key) {
        // 여기에서 각 키에 해당하는 MIDI 노트 번호를 정의
        switch (Character.toUpperCase(key)) {
            case 'A': return 60;  // 예시: 'A' 키를 누르면 MIDI 노트 60을 반환
            case 'S': return 62;
            case 'D': return 64;
            case 'F': return 65;
            case 'G': return 67;
            case 'H': return 69;
            case 'J': return 71;
            case 'K': return 72;
            // ... 추가적인 키 매핑
            case 'Q': System.exit(0);  // 'Q' 키를 누르면 프로그램 종료
            default: return -1;  // 매핑되지 않은 키는 -1 반환
        }
    }
}