package likelion15.mutsa.repository;

import likelion15.mutsa.dto.HelloResponse;
import likelion15.mutsa.entity.Hello;
import likelion15.mutsa.repository.support.Querydsl4RepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HelloRepositoryImpl extends Querydsl4RepositorySupport implements HelloRepositoryCustom {
    public HelloRepositoryImpl(){
        super(Hello.class);
    }

    @Override
    public List<HelloResponse> findByHello() {
        return null;
//        return select(new HelloResponse(hello.name))
//                .from()
    }
}
