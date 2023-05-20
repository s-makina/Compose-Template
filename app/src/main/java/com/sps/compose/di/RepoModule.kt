import com.sps.compose.data.repo.UserRepo
import com.sps.compose.data.retrofit.RetrofitInterface
import com.sps.compose.data.room.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Singleton
    @Provides
    fun provideUserRepo(retrofitInterface: RetrofitInterface, userDao: UserDao) =
        UserRepo(retrofitInterface = retrofitInterface, userDao)

}