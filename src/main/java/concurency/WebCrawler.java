package concurency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WebCrawler {

    public static void main(String[] args) {

    }

    public static List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);

        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);

        return crawl(startUrl, htmlParser, hostname, visited)
                .collect(Collectors.toList());
    }

    private static Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited) {
        Stream<String> stream = htmlParser.getUrls(startUrl)
                .parallelStream()
                .filter(url -> isSameHostname(url, hostname))
                .filter(url -> visited.add(url))
                .flatMap(url -> crawl(url, htmlParser, hostname, visited));

        return Stream.concat(Stream.of(startUrl), stream);
    }

    private static String getHostname(String url) {
        int idx = url.indexOf('/', 7);
        return (idx != -1) ? url.substring(0, idx) : url;
    }

    private static boolean isSameHostname(String url, String hostname) {
        if (!url.startsWith(hostname)) {
            return false;
        }
        return url.length() == hostname.length() || url.charAt(hostname.length()) == '/';
    }

    interface HtmlParser {
        // Return a list of all urls from a webpage of given url.
        // This is a blocking call, that means it will do HTTP request and return when this request is finished.
        public List<String> getUrls(String url);
    }
}

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        // find hostname
        int index = startUrl.indexOf('/', 7);
        String hostname = (index != -1) ? startUrl.substring(0, index) : startUrl;

        // bfs
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startUrl);
        while (!queue.isEmpty()) {
            String tmp = queue.remove();
            if (tmp.startsWith(hostname) && !result.contains(tmp)) {
                result.add(tmp);
                for (String s : htmlParser.getUrls(tmp)) {
                    queue.add(s);
                }
            }
        }
        return new ArrayList<>(result);
    }

    interface HtmlParser {
        // Return a list of all urls from a webpage of given url.
        // This is a blocking call, that means it will do HTTP request and return when this request is finished.
        public List<String> getUrls(String url);
    }
}
