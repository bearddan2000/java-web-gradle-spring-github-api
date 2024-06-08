package example.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class GitRepoPlain {
  Long id;
  Integer isDev = 0;
  String name;
  String description;
  String lang;
  String platform;
  String build;
  String clone_url;

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("[OUTPUT] ");
    sb.append(String.format("dev=%d, ", isDev));
    sb.append(String.format("name=%s, ", name));
    sb.append(String.format("description=%s, ", description));
    sb.append(String.format("platform=%s, ", platform));
    sb.append(String.format("lang=%s, ", lang));
    sb.append(String.format("build=%s, ", build));
    sb.append(String.format("downloadsUrl=%s", clone_url));

    return sb.toString();
  }
}
