package randomData

import org.apache.commons.lang.RandomStringUtils
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum

public class TestDataGenerator {
	public static Lorem lorem = LoremIpsum.getInstance();

	@Keyword
		public String getRandomParagraphs(int a, int b) {
			String ranPar = lorem.getParagraphs(a, b);
			return ranPar;
		}
		@Keyword
		public String getRandomName(int a, int b) {
			String ranPar = lorem.getName().replaceAll("[^a-zA-Z]+", "");
			return ranPar;
		}
		@Keyword
		public  String getRandomFemaleName() {
	
			String ranPar = lorem.getNameFemale().replaceAll("[^a-zA-Z]+", "");
			return ranPar;
		}
		@Keyword
		public  String getRandomMaleName() {
	
			String ranPar = lorem.getNameMale().replaceAll("[^a-zA-Z]+", "");
			return ranPar;
		}
		@Keyword
		public  String getRandomFirstName() {
	
			String ranPar = lorem.getFirstName().replaceAll("[^a-zA-Z]+", "");
			return ranPar;
		}
		@Keyword
		public static String getRandomLastName() {
	
			String ranPar = lorem.getLastName().replaceAll("[^a-zA-Z]+", "");
			return ranPar;
		}
		@Keyword
		public  String getRandomCity() {
	
			String ranPar = lorem.getCity().replaceAll("[^a-zA-Z]+", "");
			return ranPar;
		}
		@Keyword
		public  String getRandomHeading(int numberofWords) {
	
			String ranPar = lorem.getTitle(numberofWords);
			return ranPar;
		}
		@Keyword
		public  String getRandomHeading_two(int Wordsfrom, int wordstwo) {
	
			String ranPar = lorem.getTitle(Wordsfrom, wordstwo);
			return ranPar;
		}
		@Keyword
		public  String getRandomEmail() {
	
			String ranPar = lorem.getEmail();
			return ranPar;
		}
	
	@Keyword
	public final static String set_RandomNumber(long len) {
		if (len > 18)
			throw new IllegalStateException("To many digits");
		long tLen = (long) Math.pow(10, len - 1) * 9;

		long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

		String tVal = number + "";
		if (tVal.length() != len) {
			throw new IllegalStateException("The random number '" + tVal + "' is not '" + len + "' digits");
		}
		return tVal;
	}
	private static String uuidString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	@Keyword
	public static String set_RandomNumberWithText(int length){
		StringBuffer buffer = new StringBuffer();
		while (buffer.length() < length) {
			buffer.append(uuidString());
		}

		return buffer.substring(0, length);
	}
	
	
	@Keyword
	public static String getRandomPhoneNumberINDIA() {
		String phoneNumber = null;
		try {
			String allowedChars = "1234567890123456728901234567890";
			String temp = RandomStringUtils.random(9, allowedChars);
			
			String Number = temp.substring(0, temp.length());
			phoneNumber = "9"+Number;
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return phoneNumber;
	}
	
	@Keyword
	public static String getRandom_Mailiantor_Email() {
		String email = null;
		try {
			String allowedChars = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" ; // alphabets; // numbers; // special characters
			String temp = RandomStringUtils.random(12, allowedChars);
			email = temp.substring(0, temp.length()) + "@mailinator.com".trim();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		return email;
	}
}
