#include <stdio.h>
#include <time.h>
#include <sys/sysinfo.h>

void print_current_date() {
   time_t current_time;
   struct tm *time_info;

   time(&current_time);
   time_info = localtime(&current_time);

   char day_of_week[20];  
   strftime(day_of_week, sizeof(day_of_week), "%A", time_info);

   /*Print out Date*/
   printf("Current Date: %s, %s %d, %d\n", day_of_week,
      (time_info->tm_mon == 0) ? "January" :
      (time_info->tm_mon == 1) ? "February" :
      (time_info->tm_mon == 2) ? "March" :
      (time_info->tm_mon == 3) ? "April" :
      (time_info->tm_mon == 4) ? "May" :
      (time_info->tm_mon == 5) ? "June" :
      (time_info->tm_mon == 6) ? "July" :
      (time_info->tm_mon == 7) ? "August" :
      (time_info->tm_mon == 8) ? "September" :
      (time_info->tm_mon == 9) ? "October" :
      (time_info->tm_mon == 10) ? "November" : "December",  
      time_info->tm_mday,
      1900 + time_info->tm_year);
}

void print_current_time() {
   time_t current_time;
   struct tm *time_info;

   time(&current_time);
   time_info = localtime(&current_time);

   /*Print out Time*/
   printf("Current Time: %02d:%02d:%02d\n",
      time_info->tm_hour,
      time_info->tm_min,
      time_info->tm_sec);
   }

void print_system_info() {
   struct sysinfo info;
   sysinfo(&info);

   printf("Last Reboot: %ld seconds", info.uptime);
   printf(" (%.2f days)\n\n", (float)info.uptime / (24 * 3600));

   /*Print out Proccses*/
   printf("Number of Processors Configured: %d\n", get_nprocs_conf());
   printf("Number of Processors Available: %d\n", get_nprocs());
   printf("Number of Current Proccess: %d\n\n", info.procs);

   /*Print out Memory*/
   printf("Total Usable Memory Size: %.3f GB\n", (float)info.totalram / (1024 * 1024 * 1024)); //GB 3 MB 2
   printf("Available Memory Size: %.3f GB\n", (float)info.freeram / (1024 * 1024 * 1024));
   printf("Amount of Shared Memory: %.2f MB\n", (float)info.sharedram / (1024 * 1024));
   printf("Memory Used by Buffers : %.2f MB\n", (float)info.bufferram / (1024 * 1024));
   printf("Total Swap Space: %.2f MB\n", (float)info.totalswap / (1024 * 1024));
   printf("Swap Space Available: %.2f MB\n", (float)info.freeswap / (1024 * 1024));
}

int main() {
   printf("******************************\n");
   printf("** ACO350 - Allen Rodriguez **\n");
   printf("****  System Info Utility  ***\n");
   printf("******************************\n\n");

   print_current_date();
   print_current_time();
   print_system_info();

   return 0;
}
