package es.deusto.dao;

import es.deusto.data.Member;

public interface IMemberDAO {
	public void storeMember(Member member);
	public Member retrieveMemberByCod (String cod);
	public Member retrieveMemberByName (String name);

	public void updateMember (Member u);
}
