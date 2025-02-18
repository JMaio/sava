package software.sava.core.tx;

import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionVersionTest {

    @Test
    void testV0Transaction() {
        // 284yj6foQU2HDuFTfxPuiHb67vQ8vRB3oqqebAkQfVHR2sFwyuK1EHhvG4udEfsdt3xshttFmX66gKgg1Utp6RZ9
        final byte[] data = Base64.getDecoder().decode("""
        ATgc2Iye/GlwnpSeIytu+tYkb2A+5VJhc1yui59+7/PMQSuywEqpb3k8wHCKnupEuC5fDTUjvGhASTEH5c90UACAAQAFEU4rs4al2vatnKR6MtsLLzl+Q24T1Y5kkYBmPhrq9O/VzcyvadLTPMXTLHJ2IKteqvqoQAgRH4dVHOW+cw1EkNOJB31VpbsTMHY+t2f1XsB3tBoNB1994dc/uso8Y9VUcRCcPGXQaDMBtOvEnG0Lyr4Lf68erOMMjG6weDn4HuIS6tSjkUAFDNLqypEZqieck8DZMKBobFJb3fYlMJjWpjHvHv25qj1olz/ZenFlAVmw6stGZYC5aF5nQ9ZqQr8vxXTXpuq5/UeOzPqvqL7sJuBwFgO//vEZG9uw6edrxAd2vInnwNHlA4uvk7TwFNJd9xWnndlfBJ5f9fX36m+JwJ9fAlkt3jAFytFpv8wnPC/6I0tpd+F+Bw3UOdTTA8X8HR7XL/DvxwiqYIadWSBAIms1hbo9KoaOYES91ZtNIF/jeSWG+N64PtIqGyqU3OdPOEd0TTjj79CJx+HICgFkwRrNq0B12gG6uYd+a79dybCsJPRSedzSl8R6nwJYXSLJGQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAjJclj04kifG7PRApFI4NgwtaE5na/xCEBI572Nvp+FkDBkZv5SEXMv/srbpyw5vnvIzlu8X3EmssQ5s6QAAAAJWBt/6PKcF0R86zH0ytUdAc7K5LbdbpdsVcWwvkMUGK86EED9glv4WMHdJchvP2ZZvDPQq6PniaYqUsrsmZ94ETjVRi2k6UWSxzbmoMl/cGeYhlpwGEqRE3YD3BBue3swYOAAUCgE8SAA4ABQEAAAIADgAJAyKiAAAAAAAADwYdDAABFg0IllUsHJUO0hoPHQACAwwREhMUARUWFx0eGBkEHxogGxwFBgcICQoLigEyEHMzqHo5LQIAAAACAAAAAAECAAAAAgEDAAAABBIAAAAEBQQGBwIICQoLBAAMDA0ODxABCQAAABEMEhMUFQgCAAQSAAAABBYEFxgCCAoJGQQADAwNGhscCAAAABAnTB2IE8QJ6ANkAAoAAQC0ZeZpAAAAAFDDAAAAAAAAAAAAAAAAAAAAAAAAAAAQAB9Qb3dlcmVkIGJ5IGJsb1hyb3V0ZSBUcmFkZXIgQXBpAonsVzlUh3H7+XOmaklk0KWZm+wt34ECwzGrxcB6Sb7VCQRLSE8FSUpRTgQMAgsHmoTIVF9hkZWFmpxCqc8zcavo9Yu6S8ysQBz59/7iw1ADVllVAA==""");
        final var skeleton = TransactionSkeleton.deserializeSkeleton(data);

        assertEquals(TransactionVersion.V0, skeleton.version());
    }

    @Test
    void testLegacyTransaction() {
        // 5n2SRfvGFWdyNH5hLiDtz3hNr8kFkd2mDd6CBDZqcPiMr3LkzJrZnL8ySfQVZx9yxSfTMGY88rexTEfgUYBQJyVv
        final byte[] data = Base64.getDecoder().decode("""
        Ae7lSroUrQXfQc9Fn4c9RJt+PpqxycUdFw2gYXKjqs9T12t5qeSeSRdF7MlRiThHifIWpDCMK1UWAM1S/sQlHAUBAAsSMLSJTU5odXNvcy6pj5feYugrVaTKpSy1ud+RDkL0+Y5BOT5MWNTTRjvCWeyCFJkvr2GQZbeVwqEqwVyhjnK6pU2V7PhJZGrh2Pa8XYvbadYZcoTzHRFfTSf/CJxjBUhlkFW/1Yn/JAMYMhGhiwwyrR+oapFW6p2+xIpY85E6SdnghIgOwTS+teMnIQFecvosA4m/dqHJwzPkvD4430JoM/r/9U+mYMsnzpeICi7gDU7UyagvK8Zqjn80p5Z2CNhh9bvYvZB5GywKvNYVk5LQ4JDLKov3bhD+sjAdRE5kp28AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADR78leF6jTmhTlp+CrZYwd0WJTcCLsK1xMl8fwlD8CWcaMGrS0H3TmS7+AIFTmL8q+YHUynMyTHnQdotCFB8lqDzfCNUch/IXwrl4HihzBRquCZ8FEeK0704dhc+fFPfYQYqoDq2ZVYdy5s0yKNpNSeS54P92kOYZH07x7Rp6TZjJclj04kifG7PRApFI4NgwtaE5na/xCEBI572Nvp+FmYAEzBMOFhveAkaZU29JW3bh2qmW8XViePZrg/WeP1vgMGRm/lIRcy/+ytunLDm+e8jOW7xfcSayxDmzpAAAAA8iX5Oq5I3aCEOCLOak0B5kx95DZvBBe19+k1lJciIV4FSlNamSkhBk0k6HFg2jh8fDW13bySu4HkH6hAQQVEjQbd9uHudY/eGEJdvORszdq2GvxNg7kNJ/69+SjYoYv8jvzBAWsC/2QsRKlt7gGLFMLAZeDqIzNjHe1o0i4UcDEMDAYABg8NBxEAEQQDDQYAExoBAJQ1dwAAAAAJgAJ1AwAAAAAMBgACCg0HEQARBAMNAgATGgEAlDV3AAAAAAmAAnUDAAAAAAwGAAQIDQcRABEEAw0EABMaAQCUNXcAAAAACYACdQMAAAAADAYABQsNBxEAEQQDDQUAExoBAJQ1dwAAAAAJgAJ1AwAAAAAMBgABCQ0HEQARBAMNAQATGgEAlDV3AAAAAAmAAnUDAAAAAA4ACQOQ0AMAAAAAABABAE9NZW93IE1lb3cgOi0pIGh0dHBzOi8vc291bmRjbG91ZC5jb20vYmVhdHNvZm1lb3cvbGV4aS1uZXh0LWJ1bGxpc2gtb3JpZ2luYWwtbWl4""");
        final var skeleton = TransactionSkeleton.deserializeSkeleton(data);

        assertEquals(TransactionVersion.LEGACY, skeleton.version());
    }
}
