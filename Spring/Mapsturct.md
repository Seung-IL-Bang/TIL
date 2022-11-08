# MapStruct를 이용한 Mapper 자동 생성

✅ MapStruct 의존 라이브러리 설정
```gradle
dependencies {
    ...
    implementation 'org.mapstruct:mapstruct:1.4.2.Final'
	annotationProcessor 'org.mapstruct:mapstruct-processor:1.4.2.Final'
    ...
}
```

`MapStruct` 라이브러리를 사용하여 매퍼를 자동으로 생성하기 위해서는 <u>매퍼 인터페이스를 먼저 정의해야 한다.</u>

🔥 MapStruct를 이용한 mapper 자동 생성
```Java
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);

}
```

인터페이스에 애너테이션 `@Mapper`를 적용해주고 옵션으로 `componenctModel = "spring"`을 지정해주면 mapper가 Spring의 Bean으로 등록이 된다.

> 💡 Gradle이 Build task 작업을 수행 시 구현 클래스(MemberMapperImpl)가 자동으로 생성된다.

<br>

### ⭐️ DTO 클래스와 Entity 클래스의 역할 분리가 필요한 이유

1. 계층별 관심사의 분리
- API 계층 ➡️ 데이터 교환
- Service 계층 ➡️ 비즈니스 로직

2. 코드 구성의 단순화
- 각 계층별 코드 분리를 통한 유지보수 용이
  
3. REST API 스펙의 독립성 확보
- 데이터 액세스 계층에서 전달 받은 Entity를 그대로 클라이언트에 전달하면 원치 않는 데이터까지 전송될 수 있다. <u>DTO 클래스를 사용하면 원하는 정보만 제공할 수 있다.</u>

<br>

### 💧 Mapper Class 직접 구현

```java
@Component  // (1)
public class MemberMapper {
		// (2) MemberPostDto를 Member로 변환
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        return new Member(0L,
                memberPostDto.getEmail(), 
                memberPostDto.getName(), 
                memberPostDto.getPhone());
    }

		// (3) MemberPatchDto를 Member로 변환
    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        return new Member(memberPatchDto.getMemberId(),
                null, 
                memberPatchDto.getName(), 
                memberPatchDto.getPhone());
    }

    // (4) Member를 MemberResponseDto로 변환
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        return new MemberResponseDto(member.getMemberId(),
                member.getEmail(), 
                member.getName(), 
                member.getPhone());
    }
}
```

- (1)은 MemberMapper를 Spring의 Bean으로 등록하기 위해서 @Component 애너테이션을 추가했습니다. 등록된 Bean은 MemberController에서 사용됩니다.
- (2)는 MemberPostDto 클래스를 Member 클래스로 변환해주는 메서드입니다.
- (3)은 MemberPatchDto 클래스를 Member 클래스로 변환해주는 메서드입니다.
- (4)는 Member 클래스를 MemberResponseDto 클래스로 변환해주는 메서드입니다.