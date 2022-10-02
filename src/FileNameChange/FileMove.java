package FileNameChange;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// 현재 폴더 안에 있는 하위폴더의 파일들 상위폴더로 전부 이동
public class FileMove {
    public static void main(String[] args) throws IOException {
        // String strDirPath = "C:\\Users\\UserName\\Desktop\\folder";
        // ListFile( strDirPath );
    }
    private static void ListFile( String strDirPath ) throws IOException {

        File path = new File( strDirPath );
        File[] fList = path.listFiles();

        for( int i = 0; i < fList.length; i++ ) {

            if( fList[i].isFile() ) {
                // 기존파일
                File file = new File(fList[i].getPath());

                // 기존경로
                String currentPath = file.getPath();
                int startIndex = 0;
                List<Integer> list = new ArrayList<>();
                List<Integer> dotList = new ArrayList<>();
                while(currentPath.indexOf("\\", startIndex) != -1) {
                    list.add(currentPath.indexOf("\\", startIndex));
                    startIndex = currentPath.indexOf("\\", startIndex) + 1;
                }

                // 상위폴더까지 경로
                String parentsFolder = currentPath.substring(0, list.get(list.size() - 2) + 1);

                // 파일이름(확장자포함)
                String fileName = currentPath.substring(list.get(list.size() - 1) + 1);

                // 최종경로 = 상위폴더까지 경로 + 파일이름(확장자포함);
                String newName = parentsFolder + fileName;

                Path movePrev = Paths.get(currentPath);
                Path moveNext = Paths.get(newName);

                Path newPath = Files.move(movePrev, moveNext);
            }
            else if( fList[i].isDirectory() ) {
                ListFile( fList[i].getPath() );  // 재귀함수 호출
            }
        }
    }
}
