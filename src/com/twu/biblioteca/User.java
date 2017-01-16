package com.twu.biblioteca;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class User {
    @Getter
    @NonNull
    private String libraryNumber;

    @Getter
    @NonNull
    private String password;

    @Getter
    private String userName = "";

    @Getter
    private String email = "";

    @Getter
    private String phone = "";

    public String toString() {
        StringBuffer sb = new StringBuffer();

        appendLine(sb, "Library Number: ", libraryNumber);
        appendLine(sb, "User Name: ", userName);
        appendLine(sb, "Email Address: ", email);
        appendLine(sb, "Phone Number: ", phone);

        return sb.toString();
    }

    private void appendLine(StringBuffer sb, String title, String field) {
        sb.append(title);
        sb.append(field);
        sb.append('\n');
    }

}
