
List<Languages> languages = Arrays.asList(
    new Languages("English"),
    new Languages("Spanish"),
    new Languages("French"),
    new Languages("German"),
    new Languages("Italian")
);

System.out.println("What languages do you knoow")

System.out.println("Available Languages")
for (int=0; i<languages.size(); i++)(
    System.out.println((i+1)+"."+languages.get(i).getLanguage())
)

List<String> ulang = new ArrayList();

Scanner scanner = new Scanner(System.in);

System.out.println("Enter the languages that you know :")
String input = scanner.nextLine();

System.out.println("Known languages:" + ulang);
