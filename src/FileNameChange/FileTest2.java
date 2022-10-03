package FileNameChange;

import com.sun.tools.jconsole.JConsoleContext;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 현재 폴더 안에 있는 하위폴더의 파일들 상위폴더로 전부 이동
public class FileTest2 {
    public static void main(String[] args) throws IOException {
//        String strDirPath = "C:\\Users\\KH\\Downloads";
//        ListFile( strDirPath );
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
                List<Integer> slashList = new ArrayList<>();
                while(currentPath.indexOf("\\", startIndex) != -1) {
                    list.add(currentPath.indexOf("\\", startIndex));
                    startIndex = currentPath.indexOf("\\", startIndex) + 1;
                }

                // 폴더까지 경로
                String folder = currentPath.substring(0, list.get(list.size() - 1) + 1);

                // 가장 하위파일 담고있는 폴더 이름
                String folderName = currentPath.substring(list.get(list.size() - 2) + 1, list.get(list.size() - 1));

                // 확장자구분하는 . 위치 얻기위한 로직
                String fileName = currentPath.substring(list.get(list.size() -1) + 1);
                startIndex = 0;
                while (fileName.indexOf(".", startIndex) != -1) {
                    dotList.add(fileName.indexOf(".", startIndex));
                    startIndex = fileName.indexOf(".", startIndex) + 1;
                }

                startIndex = 0;
                // - 구분하는 위치 얻는 로직
                while (currentPath.indexOf("-", startIndex) != -1) {
                    slashList.add(currentPath.indexOf("-", startIndex));
                    startIndex = currentPath.indexOf("-", startIndex) + 1;
                }

                // 확장자
                String extension = fileName.substring(dotList.get(dotList.size() - 1));

                // 폴더이름
                String currentFolderName = currentPath.substring(list.get(list.size() - 1) + 1, slashList.get(slashList.size() - 1) - 1);

                // 최종경로 = 폴더까지 경로 + 폴더 이름 + "_" + 인덱스 + 확장자
                String newName = folder + currentFolderName + "\\" + fileName;

                String extensionName = ".psb .srt .ssa .ass .sub .sami .smil .smi .usf .vtt";
                // 자막 파일일경우
                String videoFile = fileName.substring(0, dotList.get(dotList.size() - 1));

                File dir = new File(folder + currentFolderName);

//                System.out.println(newName);

                Path movePrev = Paths.get(currentPath);
                Path moveNext = Paths.get(newName);

                if(!extensionName.contains(extension)) {
                    if(dir.mkdir()) {
                        System.out.println("디렉토리 생성 성공");
                    } else {
                        System.out.println("실패");
                    }
                    Path newPath = Files.move(movePrev, moveNext);
                }

            }
        }

    }
}
