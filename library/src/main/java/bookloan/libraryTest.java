package bookloan;

import java.util.ArrayList;

import org.junit.Test;

public class libraryTest {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("0001", "ISBN-1-1", "璇枃");
	Book book2 = new Book("0001", "ISBN-1-2", "璇枃");
	Book book3 = new Book("0002", "ISBN-2-1", "鑻辫");
	Book book4 = new Book("0002", "ISBN-2-2", "鑻辫");
	Member loanmember = member1;
	Book loanbook = book1;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public libraryTest() {
		/*
		 * 娣诲姞鍊熶功浜哄睘鎬�
		 */
		member1.setId("01");
		member1.setName("寮犱笁");
		member2.setId("02");
		member2.setName("鏉庡洓");
		member3.setId("03");
		member3.setName("鑰佺帇");		
		/*
		 * 娣诲姞鍊熶功璁板綍
		 */
		Loan loan1 = new Loan();
		loan1.setMember(loanmember);
		loan1.setBook(book3);
		Loans.add(loan1);				
		loanmember.setLoans(Loans);
	}

	@Test
	/* 
	 * 鍊熶功
	 */
	public void Loan() {
		 Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println("鍊熶功鎴愬姛锛�");
		 System.out.println("鍊熶功璁板綍锛�*************"+'\r'+"鍊熶功鏃堕棿: " +
		 loan.getLoanDate()+
		 " 鍒版湡鏃堕棿: " + loan.getDateForReuturn()+
		 " 鍊熶功浜�: " + loanmember.getName()+
		 " 鎵�鍊熶功绫�: " + loanbook.getTitle());
		 }
		 else{
		 System.out.println("鍊熶功涓嶆垚鍔燂紒");
		 }
		/**杩樹功**/
		loanmember.Return(loanbook); 

	}
	
	@Test
	/* 
	 * 瑙勫垯娴嬭瘯
	 */
	public void rule(){
	LoanOnlyOneSpecification one = new LoanOnlyOneSpecification(loanbook);
	System.out.println(one.IsSatisfiedBy(loanmember));		
	}

}
