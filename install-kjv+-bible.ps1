$client = new-object System.Net.WebClient
$fpath = "kjv.zip"
if(-not(Test-path $fpath -PathType leaf)) {
    $client.DownloadFile("https://codified.com/$fpath", $fpath)
} 
jar xvf $fpath
