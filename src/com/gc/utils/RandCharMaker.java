package com.gc.utils;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gc.model.QuestDTO;

public class RandCharMaker {

	public static String getRandChar() {
		int num = 0;
		num = ((int) Math.random() * 36);

		switch (num) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		case 8:
			return "I";
		case 9:
			return "J";
		case 10:
			return "K";
		case 11:
			return "L";
		case 12:
			return "M";
		case 13:
			return "N";
		case 14:
			return "O";
		case 15:
			return "P";
		case 16:
			return "Q";
		case 17:
			return "R";
		case 18:
			return "S";
		case 19:
			return "T";
		case 20:
			return "U";
		case 21:
			return "V";
		case 22:
			return "W";
		case 23:
			return "X";
		case 24:
			return "Y";
		case 25:
			return "Z";
		case 26:
			return "1";
		case 27:
			return "2";
		case 28:
			return "3";
		case 29:
			return "4";
		case 30:
			return "5";
		case 31:
			return "6";
		case 32:
			return "7";
		case 33:
			return "8";
		case 34:
			return "9";
		case 35:
			return "0";
		default:
			return "0";
		}
	}

	public static boolean checkForUse(String qCode) {
		String[] badWords = { "FUCK", "SHIT", "JIZZ", "HOES", "TITS", "CRAP", "DAMN", "ANUS", "CLIT", "COCK", "COON",
				"CUNT", "DIKE", "DYKE", "GOOK", "HEEB", "KYKE", "KUNT", "MUFF", "TWAT", "PISS", "POON", "SLUT", "TARD",
				"TWAT", "WANK" };
		
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session sess = sessFact.openSession();
		Transaction tx = sess.beginTransaction();
		Criteria crit = sess.createCriteria(QuestDTO.class);
		ArrayList<QuestDTO> questList = (ArrayList<QuestDTO>) crit.list();
		tx.commit();
		sess.close();
		
		for (int i = 0; i < badWords.length; i++) {
			if (qCode.equalsIgnoreCase(badWords[i])) {
				return false;
			}
		}
		
		for (int i = 0; i < questList.size(); i++) {
			if (qCode.equalsIgnoreCase(questList.get(i).getQuestCode())) {
				return false;
			}
		}
		
		return true;
	}
}
