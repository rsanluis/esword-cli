$client = new-object System.Net.WebClient
$client.DownloadFile("https://codified.com/kjv.zip", "kjv.zip")
jar xvf kjv.zip