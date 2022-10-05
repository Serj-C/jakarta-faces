package org.example.controller;

import beans.BandMember;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "faceletsBandMemberController")
@SessionScoped
public class BandMemberController implements Serializable {
    private List<BandMember> bandMemberList;
    private String pageTitleName = "Metal Bands";
    private final String hetfieldBio = "James Hetfield is one of the founding members of Metallica, and one of the " +
            "only 2 remaining members of the original line up (the other member being Lars Ulrich).";
    private final String ulrichBio = "Lars Ulrich was born in the city of Gentofte, Denmark, on December 26, 1963, " +
            "the son of a professional tennis player, Torben Ulrich (who also owned a jazz club). During his " +
            "childhood he lived in Copenhagen and had aspirations to be a tennis player, like his father.";
    private final String hammettBio = "Kirk Hammett was originally in the thrash metal band Exodus, until he " +
            "replaced Dave Mustaine in Metallica.";
    private final String trujilloBio = "Trujillo's career began when he met Mike Muir and Rocky George of the band " +
            "Suicidal Tendencies. In the nineties, Muir and Trujillo formed the funk rock band Infectious Grooves. " +
            "Robert was the group's bass player for several years until he left the band, and joined Ozzy Osbourne. " +
            "There he remained until 2003, when he was invited to Metallica.";
    private final String strombladBio = "Stromblad began playing music at age 4 with a violin until age 12 when he " +
            "no longer considered it a \"cool\" instrument to play and began playing guitar instead.\n";
    private final String engelinBio = "Engelin is a Swedish guitarist, mainly famous for his activity in In Flames, " +
            "Engel, and Gardenian.";
    private final String stanneBio = "In 1989, Stanne, along with Niklas Sundin, formed Dark Tranquillity, initially " +
            "under the name Septic Broiler. He played guitar on Dark Tranquillity's first album Skydancer, as well " +
            "as on their early demos. In 1993, Stanne did vocals for In Flames on the Lunar Strain album. In 1994, " +
            "Anders Fridén, Dark Tranquillity's original vocalist, left the band to join In Flames. Stanne then " +
            "became the new vocalist and discontinued playing guitar.";
    private final String iwersBio = "Brother of Anders Iwers. Along with Björn Gelotte, Iwers owns the 2112 " +
            "restaurant in Gothenburg.";
    private final String svenssonBio = "Svensson left his main band Sacrilege, where he was both drummer and singer, " +
            "in 1998 in order to join In Flames since Björn Gelotte chose to move from drums to guitars. He played " +
            "his last gig with In Flames on November 20, 2015, in Engelsdorf, Germany, and retired from music in " +
            "order to focus on his family life.";
    private BandMember current;
    private String bandMemberLast;

    public BandMemberController() {
    }

    @PostConstruct
    public void init() {
        populateMetallicaBandMemberList();
        current = getBandMemberList().get(0);
    }

    public String populateMetallicaBandMemberList() {
        bandMemberList = null;
        bandMemberList = new ArrayList<>();
        bandMemberList.add(new BandMember("James", "Hetfield", hetfieldBio));
        bandMemberList.add(new BandMember("Lars", "Ulrich", ulrichBio));
        bandMemberList.add(new BandMember("Kirk", "Hammett", hammettBio));
        bandMemberList.add(new BandMember("Robert", "Trujillo", trujilloBio));
        return "page-metallica";
    }

    public String populateTheHaloEffectBandMemberList() {
        System.out.println("Initializing band members list");
        bandMemberList = new ArrayList<>();
        bandMemberList.add(new BandMember("Jesper", "Stromblad", strombladBio));
        bandMemberList.add(new BandMember("Niclas", "Engelin", engelinBio));
        bandMemberList.add(new BandMember("Mikael", "Stanne", stanneBio));
        bandMemberList.add(new BandMember("Peter", "Iwers", iwersBio));
        bandMemberList.add(new BandMember("Daniel", "Svensson", svenssonBio));
        return "page-thehaloeffect";
    }

    public String displayBandMember(String last) {
        for (BandMember bandMember :
                bandMemberList) {
            if (bandMember.getLast().equals(last)) {
                current = bandMember;
            }
        }
        return "page-band-member";
    }

    public String getPageTitleName() {
        return pageTitleName;
    }

    public List<BandMember> getBandMemberList() {
        return bandMemberList;
    }

    public BandMember getCurrent() {
        return current;
    }
}
