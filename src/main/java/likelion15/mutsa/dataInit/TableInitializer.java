package likelion15.mutsa.dataInit;

import jakarta.annotation.PostConstruct;
import likelion15.mutsa.entity.User;
import likelion15.mutsa.entity.enums.UserAuth;
import likelion15.mutsa.entity.enums.UserStatus;
import likelion15.mutsa.service.BoardService;
import likelion15.mutsa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TableInitializer {
    private final BoardService boardService;
    private final UserService userService;
    private int boardCount;
    private int userCount = 10;
    private int commentCount;

    @PostConstruct
    @Transactional
    public void entityInitializer() {
        for (int i = 0; i < userCount; i++) {

            userService.join(
                    User.builder()
                    .email("qwe1@gmail.com")
                    .realName("성광현")
                    .name("땡땡")
                    .password("1234")
                    .phoneNumber("010-4949-5895")
                    .auth(UserAuth.USER)
                    .status(UserStatus.U)
                    .build()
            );
        }

        for (int i = 0; i < boardCount; i++) {

            for (Long j = 0L; j < userCount/2; j++) {
                String content = contents[i];
                String title = titles[i];

                boardService.writeArticle(j, title, content);
            }
        }
    }

    public void UserEntityFieldGenerator() {

    }

    // 이름 20개
    String[] realNames = {"김영희", "이지원", "박민준", "최서연", "정민지", "강준호", "윤지우", "한승민", "서예진", "임동현", "김서연", "이민재", "송지원", "장민서", "황현우", "나윤서", "정주희", "박준영", "김지호", "이하윤"};
    // 유저네임 30개
    String[] names = {"새벽별", "은하수","분한고양이","신비로움","신소천사","기로운숲","빛소녀","지개색공주","는얼굴","윗캔디","밀정원","꾸는구름","별빛마법사","자유로운바람","행복한하루","모험심","악하는별","소중한추억","달콤한마카롱","환한미소","사랑스러운햇살","멋있는모험가","힐링타임","용감한전사","맑은눈동자","사랑받는사람","활기찬에너지","달콤한초콜릿","노래하는새","자신감넘치는"};
    // 이메일 30개
    String[] emails = {"creative1@awesome.com", "innovator2@genius.net", "unique3@imaginative.org", "visionary4@creativity.com", "trailblazer5@inspire.net", "maverick6@innovation.org", "dreamer7@outofthebox.com", "artist8@imagine.net", "disruptor9@revolutionary.org", "trendsetter10@visionary.com", "pioneer11@innovate.net", "forward12@creative.org", "genius13@imagination.com", "inventor14@inspired.net", "original15@creative.org", "imaginative16@dreambig.com", "innovator17@thinkoutside.net", "creator18@unconventional.org", "ideator19@freshideas.com", "mastermind20@visionary.net", "innovator21@inspiration.org", "disruptor22@revolutionize.com", "visionary23@creative.net", "pioneer24@imagine.org", "trailblazer25@innovative.com", "trendsetter26@imagination.net", "genius27@innovate.org", "visionary28@thinkbig.com", "maverick29@originality.net", "artist30@imaginative.org"};
    // 제목 40개
    String[] titles = {"위원은 에 의지 아니한다.",
            "누구든지 체포 또는 구속 정하는 자없이 통지되어야 한다.",
            "국무총리는 대부를 통할한다.",
            "헌법재판소 재판관의 임기.",
            "나는 헌법을 준수하성실.",
            "모든 국민은 고문을 니한다.",
            "행정각부의 설아니한다.",
            "원장은 국 수 있다.",
            "대한민국략적 전쟁을 부인한다.",
            "대통령이 궐위되다.",
            "모든 국민은 법률이 정하는 바에 의하여 납세의 의무를 진다.",
            "전직대통령의 신분과 예관으로 구성된 법원에 속한다.",
            "재의의 요구가 있을 때 찬성으로 전과 같은 의결을 하면 그 법률안은 법률로서 확정된다.",
            "국회는 법수 있다.",
            "국회는 국민의 보통·평다.",
            "공무원은 국민전체에 대한 봉사자이며, 국민에 대하여 책임을 진다.",
            "국정로자문회의를 둘 수 있다.",
            "언론·출니한다.",
            "대통령은회.",
            "헌법재판소 재판관다.",
            "잔디가 어머님, 별 합니다.",
            "흙으로 차 이런 별에도 나는 그리워 있다.",
            "나의 잔디가는 나는 소녀들의 마리아 계십니다.",
            "속의 동경과 하나에 봅니다. 이름을 잔디가 흙으로 지나고 까닭입니다. 마디씩 못 내린 헤일 계십니다.",
            "아스라히 쓸쓸닭입니다.",
            "위 듯니다.",
            "다하지 그님, 거외다.",
            "멀듯이, 는 아스라히 듯합니다.",
            "별, 멀리 듯합니다. 이름과 토끼, 나는 계십니다.",
            "별 까닭이.",
            "쓸, 아무  다하지 봅니다.",
            "사멀리 밤을 계십니다. 헤일 봅니다.",
            "벌상을 어머니 별이 하니다.",
            "아무집애들의 한 당신불러 있습 불러 있습니다.",
            "나는 토끼, 내 이웃 이름과, 지나못 옥 거외다.",
            "노루, 다. 하나에다.",
            "옥  무절이었습니다.",
            "새겨지는 멀리 니다.",
            "위에 차 새겨지는 별이 둘니다.",
            "추억과 무덤 어머의 자랑처럼 있습니다."};
    // 본문 내용 40개
    String[] contents = {"국회나 그 위원회의 요구가 있을 때에는 국무총리·국무위원 또는 정부위원은 출석·답변하여야 하며, 국무총리 또는 국무위원이 출석요구를 받은 때에는 국무위원 또는 정부위원으로 하여금 출석·답변하게 할 수 있다. 통신·방송의 시설기준과 신문의 기능을 보장하기 위하여 필요한 사항은 법률로 정한다. 대통령은 내란 또는 외환의 죄를 범한 경우를 제외하고는 재직중 형사상의 소추를 받지 아니한다. 일반사면을 명하려면 국회의 동의를 얻어야 한다. 대한민국은 민주공화국이다. 헌법재판소의 장은 국회의 동의를 얻어 재판관중에서 대통령이 임명한다. 법률안에 이의가 있을 때에는 대통령은 제1항의 기간내에 이의서를 붙여 국회로 환부하고, 그 재의를 요구할 수 있다. 국회의 폐회중에도 또한 같다.",
            "헌법재판소에서 법률의 위헌결정, 탄핵의 결정, 정당해산의 결정 또는 헌법소원에 관한 인용결정을 할 때에는 재판관 6인 이상의 찬성이 있어야 한다. 모든 국민은 신체의 자유를 가진다. 누구든지 법률에 의하지 아니하고는 체포·구속·압수·수색 또는 심문을 받지 아니하며, 법률과 적법한 절차에 의하지 아니하고는 처벌·보안처분 또는 강제노역을 받지 아니한다. 정부는 회계연도마다 예산안을 편성하여 회계연도 개시 90일전까지 국회에 제출하고, 국회는 회계연도 개시 30일전까지 이를 의결하여야 한다. 민주평화통일자문회의의 조직·직무범위 기타 필요한 사항은 법률로 정한다. 신체장애자 및 질병·노령 기타의 사유로 생활능력이 없는 국민은 법률이 정하는 바에 의하여 국가의 보호를 받는다.",
            "군사재판을 관할하기 위하여 특별법원으로서 군사법원을 둘 수 있다. 행정각부의 장은 국무위원 중에서 국무총리의 제청으로 대통령이 임명한다. 환경권의 내용과 행사에 관하여는 법률로 정한다. 중앙선거관리위원회는 대통령이 임명하는 3인, 국회에서 선출하는 3인과 대법원장이 지명하는 3인의 위원으로 구성한다. 위원장은 위원중에서 호선한다. 선거운동은 각급 선거관리위원회의 관리하에 법률이 정하는 범위안에서 하되, 균등한 기회가 보장되어야 한다. 대한민국의 국민이 되는 요건은 법률로 정한다. 국가는 여자의 복지와 권익의 향상을 위하여 노력하여야 한다. 언론·출판은 타인의 명예나 권리 또는 공중도덕이나 사회윤리를 침해하여서는 아니된다. 언론·출판이 타인의 명예나 권리를 침해한 때에는 피해자는 이에 대한 피해의 배상을 청구할 수 있다.",
            "헌법개정은 국회재적의원 과반수 또는 대통령의 발의로 제안된다. 대법원과 각급법원의 조직은 법률로 정한다. 대한민국의 영토는 한반도와 그 부속도서로 한다. 모든 국민은 법률이 정하는 바에 의하여 국가기관에 문서로 청원할 권리를 가진다. 국가는 대외무역을 육성하며, 이를 규제·조정할 수 있다. 정당의 설립은 자유이며, 복수정당제는 보장된다. 계엄을 선포한 때에는 대통령은 지체없이 국회에 통고하여야 한다. 국무총리·국무위원 또는 정부위원은 국회나 그 위원회에 출석하여 국정처리상황을 보고하거나 의견을 진술하고 질문에 응답할 수 있다. 국무위원은 국무총리의 제청으로 대통령이 임명한다.",
            "지방자5일 이 법률로 정한다.",
            "대통령으로 선거될 수 있는 자는 국회의원의 피선거권이 있고 선거일 현재 40세에 달하여야 한다. 국회는 의원의 자격을 심사하며, 의원을 징계할 수 있다. 누구든지 체포 또는 구속의 이유와 변호인의 조력을 받을 권리가 있음을 고지받지 아니하고는 체포 또는 구속을 당하지 아니한다. 체포 또는 구속을 당한 자의 가족등 법률이 정하는 자에게는 그 이유와 일시·장소가 지체없이 통지되어야 한다. 국가는 모성의 보호를 위하여 노력하여야 한다. 국채를 모집하거나 예산외에 국가의 부담이 될 계약을 체결하려 할 때에는 정부는 미리 국회의 의결을 얻어야 한다. 한 회계연도를 넘어 계속하여 지출할 필요가 있을 때에는 정부는 연한을 정하여 계속비로서 국회의 의결을 얻어야 한다.",
            "감사원은 원장을 포함한 5인 이상 11인 이하의 감사위원으로 구성한다. 훈장등의 영전은 이를 받은 자에게만 효력이 있고, 어떠한 특권도 이에 따르지 아니한다. 국가는 균형있는 국민경제의 성장 및 안정과 적정한 소득의 분배를 유지하고, 시장의 지배와 경제력의 남용을 방지하며, 경제주체간의 조화를 통한 경제의 민주화를 위하여 경제에 관한 규제와 조정을 할 수 있다. 헌법재판소의 조직과 운영 기타 필요한 사항은 법률로 정한다. 국회는 상호원조 또는 안전보장에 관한 조약, 중요한 국제조직에 관한 조약, 우호통상항해조약, 주권의 제약에 관한 조약, 강화조약, 국가나 국민에게 중대한 재정적 부담을 지우는 조약 또는 입법사항에 관한 조약의 체결·비준에 대한 동의권을 가진다.",
            "여자의 근로는 특별한 보호를 받으며, 고용·임금 및 근로조건에 있어서 부당한 차별을 받지 아니한다. 체포·구속·압수 또는 수색을 할 때에는 적법한 절차에 따라 검사의 신청에 의하여 법관이 발부한 영장을 제시하여야 한다. 다만, 현행범인인 경우와 장기 3년 이상의 형에 해당하는 죄를 범하고 도피 또는 증거인멸의 염려가 있을 때에는 사후에 영장을 청구할 수 있다. 누구든지 체포 또는 구속을 당한 때에는 즉시 변호인의 조력을 받을 권리를 가진다. 다만, 형사피고인이 스스로 변호인을 구할 수 없을 때에는 법률이 정하는 바에 의하여 국가가 변호인을 붙인다. 이 헌법에 의한 최초의 대통령의 임기는 이 헌법시행일로부터 개시한다.",
            "헌법에 의하여 체결·공포된 조약과 일반적으로 승인된 국제법규는 국내법과 같은 효력을 가진다. 모든 국민은 헌법과 법률이 정한 법관에 의하여 법률에 의한 재판을 받을 권리를 가진다. 의무교육은 무상으로 한다. 국회의원의 수는 법률로 정하되, 200인 이상으로 한다. 국민경제의 발전을 위한 중요정책의 수립에 관하여 대통령의 자문에 응하기 위하여 국민경제자문회의를 둘 수 있다. 혼인과 가족생활은 개인의 존엄과 양성의 평등을 기초로 성립되고 유지되어야 하며, 국가는 이를 보장한다. 국회는 헌법개정안이 공고된 날로부터 60일 이내에 의결하여야 하며, 국회의 의결은 재적의원 3분의 2 이상의 찬성을 얻어야 한다.",
            "군인·군무원·경찰공무원 기타 법률이 정하는 자가 전투·훈련등 직무집행과 관련하여 받은 손해에 대하여는 법률이 정하는 보상외에 국가 또는 공공단체에 공무원의 직무상 불법행위로 인한 배상은 청구할 수 없다. 국가는 평생교육을 진흥하여야 한다. 근로조건의 기준은 인간의 존엄성을 보장하도록 법률로 정한다. 타인의 범죄행위로 인하여 생명·신체에 대한 피해를 받은 국민은 법률이 정하는 바에 의하여 국가로부터 구조를 받을 수 있다. 법률은 특별한 규정이 없는 한 공포한 날로부터 20일을 경과함으로써 효력을 발생한다. 공무원의 신분과 정치적 중립성은 법률이 정하는 바에 의하여 보장된다.",
            "모든 국의원 무원이 아닌 국민은  그 공무원이 최초로 선출 또는 임명된 때로부터 적용한다.",
            "원장은 국회의 동의를 얻어 대통령이 임명하고, 그 임기는 4년으로 하며, 1차에 한하여 중임할 수 있다. 평화통일정책의 수립에 관한 대통령의 자문에 응하기 위하여 민주평화통일자문회의를 둘 수 있다. 모든 국민은 법률이 정하는 바에 의하여 국방의 의무를 진다. 정당은 법률이 정하는 바에 의하여 국가의 보호를 받으며, 국가는 법률이 정하는 바에 의하여 정당운영에 필요한 자금을 보조할 수 있다. 모든 국민은 인간으로서의 존엄과 가치를 가지며, 행복을 추구할 권리를 가진다. 국가는 개인이 가지는 불가침의 기본적 인권을 확인하고 이를 보장할 의무를 진다. 대통령·국무총리·국무위원·행정각부의 장·헌법재판소 재판관·법관·중앙선거관리위원회 위원·감사원장·감사위원 기타 법률이 정한 공무원이 그 직무집행에 있어서 헌법이나 법률을 위배한 때에는 국회는 탄핵의 소추를 의결할 수 있다.",
            "모든  선거관리위원회는 법령의 범위안에서 선거관리·국민투표관리 또는 정당사무에 관한 규칙을 제정할 수 있으며, 법률에 저촉되지 아니하는 범위안에서 내부규율에 관한 규칙을 제정할 수 있다. 대한민국은 통일을 지향하며, 자유민주적 기본질서에 입각한 평화적 통일 정책을 수립하고 이를 추진한다. 모든 국민은 건강하고 쾌적한 환경에서 생활할 권리를 가지며, 국가와 국민은 환경보전을 위하여 노력하여야 한다. 모든 국민은 법 앞에 평등하다. 누구든지 성별·종교 또는 사회적 신분에 의하여 정치적·경제적·사회적·문화적 생활의 모든 영역에 있어서 차별을 받지 아니한다.",
            "학교교육 및 평생교육을 포함한 교육제도와 그 운영, 교육재정 및 교원의 지위에 관한 기본적인 사항은 법률로 정한다. 군사법원의 조직·권한 및 재판관의 자격은 법률로 정한다. 국가는 건전한 소비행위를 계도하고 생산품의 품질향상을 촉구하기 위한 소비자보호운동을 법률이 정하는 바에 의하여 보장한다. 탄핵결정은 공직으로부터 파면함에 그친다. 그러나, 이에 의하여 민사상이나 형사상의 책임이 면제되지는 아니한다. 정기회의 회기는 100일을, 임시회의 회기는 30일을 초과할 수 없다. 국회는 법률에 저촉되지 아니하는 범위안에서 의사와 내부규율에 관한 규칙을 제정할 수 있다. 제3항의 승인을 얻지 못한 때에는 그 처분 또는 명령은 그때부터 효력을 상실한다. 이 경우 그 명령에 의하여 개정 또는 폐지되었던 법률은 그 명령이 승인을 얻지 못한 때부터 당연히 효력을 회복한다.",
            "국회가 재적의원 과반수의 찬성으로 계엄의 해제를 요구한 때에는 대통령은 이를 해제하여야 한다. 이 헌법시행 당시의 법령과 조약은 이 헌법에 위배되지 아니하는 한 그 효력을 지속한다. 모든 국민은 언론·출판의 자유와 집회·결사의 자유를 가진다. 정당의 목적이나 활동이 민주적 기본질서에 위배될 때에는 정부는 헌법재판소에 그 해산을 제소할 수 있고, 정당은 헌법재판소의 심판에 의하여 해산된다. 공공필요에 의한 재산권의 수용·사용 또는 제한 및 그에 대한 보상은 법률로써 하되, 정당한 보상을 지급하여야 한다. 국가는 재해를 예방하고 그 위험으로부터 국민을 보호하기 위하여 노력하여야 한다.",
            "대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다. 모든 국민은 고문을 받지 아니하며, 형사상 자기에게 불리한 진술을 강요당하지 아니한다. 누구든지 체포 또는 구속을 당한 때에는 적부의 심사를 법원에 청구할 권리를 가진다. 대법관의 임기는 6년으로 하며, 법률이 정하는 바에 의하여 연임할 수 있다. 국가는 농지에 관하여 경자유전의 원칙이 달성될 수 있도록 노력하여야 하며, 농지의 소작제도는 금지된다. 선거와 국민투표의 공정한 관리 및 정당에 관한 사무를 처리하기 위하여 선거관리위원회를 둔다. 전직대통령의 신분과 예우에 관하여는 법률로 정한다. 대통령의 임기연장 또는 중임변경을 위한 헌법개정은 그 헌법개정 제안 당시의 대통령에 대하여는 효력이 없다.",
            "모든 국민은 보건에 관하여 국가의 보호를 받는다. 이 헌법시행 당시에 이 헌법에 의하여 새로 설치될 기관의 권한에 속하는 직무를 행하고 있는 기관은 이 헌법에 의하여 새로운 기관이 설치될 때까지 존속하며 그 직무를 행한다. 대법관은 대법원장의 제청으로 국회의 동의를 얻어 대통령이 임명한다. 국회의 회의는 공개한다. 다만, 출석의원 과반수의 찬성이 있거나 의장이 국가의 안전보장을 위하여 필요하다고 인정할 때에는 공개하지 아니할 수 있다. 대법원장과 대법관이 아닌 법관은 대법관회의의 동의를 얻어 대법원장이 임명한다. 모든 국민은 능력에 따라 균등하게 교육을 받을 권리를 가진다.",
            "국무총리는 대통령을 보좌하며, 행정에 관하여 대통령의 명을 받아 행정각부를 통할한다. 대통령은 국회에 출석하여 발언하거나 서한으로 의견을 표시할 수 있다. 국회의원은 현행범인인 경우를 제외하고는 회기중 국회의 동의없이 체포 또는 구금되지 아니한다. 대통령의 임기는 5년으로 하며, 중임할 수 없다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에 필요한 서류의 제출 또는 증인의 출석과 증언이나 의견의 진술을 요구할 수 있다. 언론·출판에 대한 허가나 검열과 집회·결사에 대한 허가는 인정되지 아니한다. 모든 국민은 근로의 권리를 가진다. 국가는 사회적·경제적 방법으로 근로자의 고용의 증진과 적정임금의 보장에 노력하여야 하며, 법률이 정하는 바에 의하여 최저임금제를 시행하여야 한다.",
            "국회의원의 선거구와 비례대표제 기타 선거에 관한 사항은 법률로 정한다. 대법원장의 임기는 6년으로 하며, 중임할 수 없다. 예비비는 총액으로 국회의 의결을 얻어야 한다. 예비비의 지출은 차기국회의 승인을 얻어야 한다. 농업생산성의 제고와 농지의 합리적인 이용을 위하거나 불가피한 사정으로 발생하는 농지의 임대차와 위탁경영은 법률이 정하는 바에 의하여 인정된다. 국가는 농업 및 어업을 보호·육성하기 위하여 농·어촌종합개발과 그 지원등 필요한 계획을 수립·시행하여야 한다. 대통령이 궐위되거나 사고로 인하여 직무를 수행할 수 없을 때에는 국무총리, 법률이 정한 국무위원의 순서로 그 권한을 대행한다.",
            "이 헌법시행 당시의 대법원장과 대법원판사가 아닌 법관은 제1항 단서의 규정에 불구하고 이 헌법에 의하여 임명된 것으로 본다. 대통령은 국가의 독립·영토의 보전·국가의 계속성과 헌법을 수호할 책무를 진다. 대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 존중함을 기본으로 한다. 대통령은 전시·사변 또는 이에 준하는 국가비상사태에 있어서 병력으로써 군사상의 필요에 응하거나 공공의 안녕질서를 유지할 필요가 있을 때에는 법률이 정하는 바에 의하여 계엄을 선포할 수 있다. 제1항의 탄핵소추는 국회재적의원 3분의 1 이상의 발의가 있어야 하며, 그 의결은 국회재적의원 과반수의 찬성이 있어야 한다. 다만, 대통령에 대한 탄핵소추는 국회재적의원 과반수의 발의와 국회재적의원 3분의 2 이상의 찬성이 있어야 한다.",
            "같이 관현악이며, 미인을 있으랴? 일월과 위하여서 힘차게 지혜는 돋고, 힘있다. 지혜는 인간의 있는 것은 것이다. 부패를 방황하였으며, 영락과 않는 위하여서, 사막이다. 영원히 가장 있을 것이다.보라, 말이다. 일월과 현저하게 만물은 우리의 있는 놀이 같이 인도하겠다는 있다. 우리는 너의 보내는 이상이 이상의 이것을 눈에 군영과 청춘은 아름다우냐? 있는 위하여 수 피고, 이상은 무엇이 것이다. 과실이 있는 오직 인간에 곧 위하여서 가지에 돋고, 때문이다.",
            " 것 창공에 무한한 천고에 뼈 오직 구하기 이는 속에서 우리는 하는 행복스럽고 주는 못할 기쁘며, 있다. 듣기만 기관과 남는 피다. 같은 그들은 긴지라 피가 그와 몸이 할지라도 황금시대다. 두기 가슴에 일월과 돋고, 이상 영락과 피가 것이다.",
            "인도하겠다는 석가는 그들의 피고 바이며, 피부가 얼마나 같이, 이상의 운다. 같지 새 것은 생의 피부가 보이는 우는 것이다. 목숨이 앞이 노래하며 청춘의 봄바람이다. 그들은 투명하되 찬미를 대중을 힘차게 얼마나 있는가? 놀이 같지 따뜻한 크고 청춘 보는 철환하였는가? 능히 두손을 구할 듣는다. 이 시들어 천고에 힘차게 쓸쓸한 생의 이상 그들에게 운다. 새 간에 가진 영락과 칼이다. 붙잡아 인간의 스며들어 청춘이 같지 이것이다. 충분히 싹이 것이다.보라, 길지 많이 우리 아니한 안고, 것이다.",
            "산야에 이상이 온갖 청춘의 간에 군영과 길을 황금시대다. 든 미인을 것은 그들을 발휘하기 같이, 용감하고 커다란 얼마나 아름다우냐? 유소년에게서 청춘에서만 얼음이 얼음에 천자만홍이 못하다 심장의 칼이다. 인생에 구하지 속잎나고, 따뜻한 못할 바로 철환하였는가? 고행을 품에 꾸며 보는 듣기만 황금시대다. 그들을 이 방황하였으며, 없으면 청춘이 이것이다. 얼마나 있음으로써 그러므로 그리하였는가? 있으며, 그들은 시들어 있으랴? 품었기 들어 트고, 있다. 보이는 예가 꾸며 그들의 사막이다.",
            "그들은 것이다.보라, 목숨이 피에 수 열락의 보라. 더운지라 그들에게 사람은 얼음과 실현에 부패를 때문이다. 찾아다녀도, 바이며, 우는 없으면 칼이다. 크고 힘차게 위하여, 풍부하게 힘있다. 밝은 사는가 것은 우리의 인간에 무엇이 힘있다. 주며, 이상, 방황하였으며, 있을 이상의 없으면, 말이다. 인류의 청춘의 따뜻한 가슴이 찬미를 싶이 꽃이 같이 바이며, 있는가? 가슴에 것은 우리 그것을 자신과 생생하며, 위하여 생의 위하여서. 품었기 그러므로 산야에 두기 투명하되 간에 심장은 열매를 말이다. 열락의 얼마나 있는 새가 힘있다.",
            "생생하며, 있는 소금이라 눈이 기관과 불러 같이, 아름다우냐? 위하여 많이 황금시대를 아름답고 보이는 간에 얼마나 오아이스도 이것이다. 예가 눈이 할지니, 아름다우냐? 안고, 커다란 부패를 우리 살 행복스럽고 있는가? 역사를 부패를 꽃이 위하여서. 같은 무엇을 기쁘며, 찾아 하였으며, 곳이 바이며, 군영과 인간에 사막이다. 뭇 위하여 위하여서 때에, 가치를 생의 돋고, 살았으며, 인간에 것이다. 품고 뜨고, 방지하는 이것은 우리의 더운지라 있는 사막이다. 인생의 청춘에서만 피가 이상 어디 청춘을 이것이다.",
            "수 밥을 것은 하는 물방아 얼마나 피고 아름다우냐? 착목한는 피부가 장식하는 인간의 찬미를 얼음과 것이다. 있음으로써 이상의 인생의 자신과 천고에 품에 것이다. 우리는 청춘이 일월과 인생의 위하여서 피부가 귀는 이상의 그러므로 말이다. 얼음과 동산에는 유소년에게서 창공에 우는 노년에게서 있다. 위하여, 주며, 되는 이상 용기가 새가 황금시대를 인생에 때문이다. 곳으로 몸이 이 목숨을 방지하는 고동을 미인을 이상, 뿐이다. 꾸며 부패를 청춘 칼이다. 피어나는 얼마나 얼음 붙잡아 이상은 열락의 행복스럽고 들어 없으면, 철환하였는가? 살 간에 청춘의 주는 사람은 설레는 너의 같이 영원히 쓸쓸하랴? 사는가 인생에 청춘을 위하여 끝까지 아름다우냐?",
            "새가 눈이 이상은 피어나는 우리의 새 눈에 목숨을 열락의 이것이다. 미묘한 튼튼하며, 인류의 장식하는 봄바람을 주는 교향악이다. 없는 우리 인간의 황금시대다. 길을 일월과 그들을 것이다. 인생의 하는 위하여서 타오르고 속에서 위하여 봄날의 인생을 황금시대를 것이다. 목숨이 설산에서 봄날의 우리의 것이다. 남는 바이며, 옷을 것이다. 가슴이 열락의 그들의 동산에는 같이, 수 위하여서. 심장의 있을 것은 같이, 몸이 청춘의 끓는 교향악이다.",
            "것은 피에 있음으로써 얼음과 끓는다. 예가 지혜는 않는 그들은 이것이다. 대한 이성은 인생에 위하여 꽃이 곧 칼이다. 사랑의 위하여 우리의 있으랴? 열락의 살 살았으며, 그들은 불어 모래뿐일 우리 구하기 것이다. 이는 이상의 뭇 우리 아름다우냐? 이상의 커다란 황금시대를 풍부하게 그들의 귀는 끓는다. 끝에 있는 싸인 피고, 지혜는 얼마나 착목한는 동력은 두기 이것이다. 부패를 실현에 위하여 이상, 있으며, 그리하였는가?",
            "수 원대하고, 두손을 무한한 대고, 듣는다. 이 부패를 위하여 풀밭에 그들의 힘있다. 풍부하게 얼음이 그들을 있는 있으랴? 귀는 뭇 방황하여도, 보는 교향악이다. 이것을 얼마나 가지에 갑 지혜는 속잎나고, 하여도 천지는 이것이다. 피어나기 천지는 인간은 그것을 약동하다. 시들어 웅대한 못할 열매를 피고 것이다. 그들의 눈이 사람은 이상은 청춘에서만 아름다우냐? 그들은 뜨거운지라, 그들에게 그림자는 모래뿐일 봄바람이다. 두손을 수 이상의 황금시대를 속에서 부패를 싶이 철환하였는가? 오아이스도 못하다 싸인 피가 기관과 방지하는 희망의 주는 끓는 운다.",
            "남는 동산에는 그들은 미묘한 무엇을 용감하고 이상 열락의 사막이다. 사라지지 그러므로 돋고, 이 인간의 어디 가지에 얼마나 생의 것이다. 하여도 그림자는 피가 못하다 피다. 청춘의 할지니, 두기 있을 있는 곳이 것이다. 인생에 것은 불어 때문이다. 귀는 것은 이것은 찾아다녀도, 일월과 쓸쓸하랴? 위하여 그들은 것이다.보라, 천고에 것은 있는 가진 얼음과 뿐이다. 그들의 두기 이상 봄바람이다. 찾아 기쁘며, 지혜는 같이, 커다란 얼마나 있다. 같이, 위하여 그림자는 그들의 품에 원질이 인생을 이것이다. 용기가 무엇이 뭇 때에, 이것이다.",
            "이것을 청춘에서만 타오르고 들어 있을 뼈 지혜는 그리하였는가? 원대하고, 용감하고 구하기 보내는 가는 그들은 가장 있으랴? 곧 노래하며 있음으로써 목숨을 구하지 시들어 사막이다. 간에 우는 생생하며, 청춘 눈에 가슴에 산야에 끓는다. 목숨이 낙원을 같지 반짝이는 얼마나 황금시대다. 심장의 천자만홍이 피고 이상은 얼마나 무엇을 청춘의 크고 쓸쓸하랴? 풀이 피고, 봄바람을 길지 심장은 부패를 속에 이것이다. 것은 뜨거운지라, 황금시대의 것은 것은 살 힘차게 얼음이 끝에 때문이다. 그것을 있는 고동을 지혜는 길지 것은 있는가? 설레는 남는 이상이 목숨이 가장 귀는 운다.",
            "밝은 곧 노년에게서 위하여서, 설산에서 끓는다. 피어나는 트고, 방황하여도, 찾아다녀도, 이것이다. 작고 우리 인간이 설산에서 이상, 것이다. 석가는 가는 이것을 뭇 동산에는 피가 보내는 너의 철환하였는가? 반짝이는 인생을 무엇을 몸이 같이 가치를 약동하다. 천고에 아름답고 대한 방지하는 듣는다. 하는 반짝이는 풀밭에 같이 돋고, 구하기 너의 유소년에게서 것이다. 발휘하기 뜨고, 가슴에 못할 대한 용감하고 고행을 말이다. 굳세게 오직 뜨고, 많이 피는 눈에 천고에 것이다. 피에 방황하였으며, 무엇이 이상이 보이는 칼이다.",
            "지혜는 보내는 뜨고, 인간이 맺어, 아니한 사막이다. 같이 광야에서 발휘하기 무엇을 수 대고, 어디 우리 봄바람이다. 위하여, 간에 장식하는 봄바람이다. 미인을 원질이 있는 풀이 싹이 같으며, 것이다. 싶이 풀밭에 그러므로 따뜻한 청춘 능히 있으며, 품었기 쓸쓸하랴? 가슴에 이것을 실현에 위하여서. 청춘의 못하다 시들어 이상의 실로 위하여 얼마나 봄바람이다. 작고 예가 피어나기 이상을 어디 황금시대를 대고, 이것이다. 있는 굳세게 얼마나 밥을 힘있다. 바로 얼마나 피부가 물방아 가슴에 만천하의 끓는다. 천고에 인간은 영원히 현저하게 위하여서 같은 가치를 않는 뿐이다.",
            "사라지지 오아이스도 사람은 인간은 더운지라 열매를 바로 간에 그리하였는가? 오직 이것을 힘차게 창공에 것이다. 어디 용기가 불어 것이다. 같은 꽃이 사람은 무엇을 보라. 황금시대를 없으면 얼음에 가치를 뿐이다. 용기가 사랑의 광야에서 이것을 너의 장식하는 두기 것이다. 장식하는 그것은 동산에는 착목한는 그림자는 하는 피고, 목숨이 힘있다. 따뜻한 청춘의 풀밭에 밥을 열매를 어디 그들의 청춘의 만물은 것이다. 충분히 천고에 불러 맺어, 귀는 산야에 곳으로 품에 힘차게 것이다.",
            "이상의 그러므로 뼈 트고, 청춘을 구하기 가슴이 위하여서. 바이며, 그림자는 기관과 아름다우냐? 있음으로써 바이며, 어디 인간의 뜨거운지라, 싶이 행복스럽고 없는 많이 그리하였는가? 발휘하기 천지는 청춘을 천고에 되는 싹이 아름다우냐? 자신과 가지에 살았으며, 그들의 교향악이다. 끓는 보는 예수는 피어나는 뜨고, 밥을 뛰노는 듣는다. 원질이 열락의 그들을 품고 이것이다. 청춘의 굳세게 내는 못하다 하는 하는 뭇 구하기 쓸쓸하랴? 길을 못하다 든 설레는 때문이다. 없는 그들은 무엇을 되는 불어 운다. 갑 봄날의 많이 튼튼하며, 찾아다녀도, 때에, 오직 것이다.",
            "온갖 구하기 얼음에 끝까지 많이 심장은 황금시대를 것은 쓸쓸하랴? 때까지 하였으며, 청춘은 인생에 황금시대의 봄바람이다. 얼마나 피가 살 있는가? 풍부하게 그들은 봄바람을 만천하의 소금이라 현저하게 열락의 대한 피다. 어디 희망의 갑 인간이 속에 얼마나 얼마나 아름다우냐? 품었기 일월과 영원히 전인 그들은 그들을 같은 그와 피부가 그리하였는가? 능히 가슴에 봄바람을 살 가장 하였으며, 철환하였는가? 군영과 있음으로써 용감하고 이 청춘의 하였으며, 끝까지 이것이다. 옷을 주는 인생에 기쁘며, 피다. 없는 용기가 살 이상의 옷을 노래하며 가치를 날카로우나 철환하였는가?",
            "뜨거운지라, 대고, 기쁘며, 사라지지 쓸쓸한 아름다우냐? 내는 아름답고 군영과 수 보배를 인도하겠다는 뭇 것이다. 사는가 품고 같지 풍부하게 끓는 스며들어 천지는 우리의 따뜻한 뿐이다. 희망의 청춘 인도하겠다는 천고에 그와 이것이다. 남는 보는 보이는 품었기 용기가 사막이다. 청춘이 별과 물방아 피부가 이상 뿐이다. 투명하되 우리 하는 황금시대를 별과 곳이 기쁘며, 뿐이다. 남는 그것을 할지라도 평화스러운 원질이 옷을 이것이다. 인류의 구하지 것은 하였으며, 그들은 투명하되 같이, 피가 위하여서. 황금시대의 못할 행복스럽고 뭇 찾아다녀도, 피에 사람은 뿐이다.",
            "것이다.보라, 때에, 목숨이 가슴에 천고에 길을 든 사막이다. 풍부하게 풀밭에 위하여, 두손을 커다란 열락의 것이다. 봄날의 얼마나 밥을 이상은 사랑의 들어 그러므로 이것이다. 싸인 이것은 피가 이상을 내는 피에 공자는 밝은 창공에 뿐이다. 뜨고, 뜨거운지라, 길을 것은 같으며, 청춘 칼이다. 보이는 기쁘며, 구하지 봄바람을 위하여서, 노년에게서 얼마나 것이다. 이 충분히 보는 봄날의 더운지라 인생을 꽃이 약동하다. 굳세게 풀이 하여도 투명하되 우리 것이다. 청춘의 되는 청춘의 구하기 희망의 끓는 대고, 교향악이다. 청춘의 이상의 타오르고 따뜻한 할지니, 우리의 용감하고 같이, 보라. 목숨이 끓는 그들을 천고에 가치를 얼음이 품고 철환하였는가?",
            "청춘이 지혜는 용기가 눈이 원대하고, 찾아 황금시대다. 목숨을 창공에 피부가 청춘 풀이 능히 그들은 이성은 운다. 튼튼하며, 크고 인간이 같지 안고, 따뜻한 영원히 무엇을 때문이다. 할지니, 풀이 풍부하게 산야에 천고에 인간의 피고 것이다. 영원히 봄바람을 보내는 뜨고, 가는 붙잡아 어디 이것을 가슴이 칼이다. 두기 얼마나 커다란 듣는다. 끓는 그들의 원대하고, 같으며, 끝에 것이다. 이상이 않는 청춘이 만물은 것이 그들은 위하여서. 기관과 웅대한 있으며, 하여도 힘있다."};

}
