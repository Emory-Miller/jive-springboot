package rocks.zipcode.Jive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.zipcode.Jive.entities.Member;
import rocks.zipcode.Jive.repositories.MemberRepository;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberByID(Long idUser) {
        return memberRepository.findById(idUser).get();

    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMemberByID(Long idUser) {
        memberRepository.deleteById(idUser);
    }
}