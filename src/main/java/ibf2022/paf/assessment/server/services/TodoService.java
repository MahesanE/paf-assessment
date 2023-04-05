package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7

@Service
public class TodoService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    TaskRepository taskRepo;

    @Transactional
public boolean upsertTask(List<Task> tasks, String username) {
    Optional<User> optionalUser = userRepo.findUserByUsername(username);

    User user;
    if (optionalUser.isPresent()) {
        user = optionalUser.get();
    } else {
        user = new User();
        user.setUsername(username);
        user.setName(username);
        String userId = userRepo.insertUser(user);
        user.setUserId(userId);
    }

    for (Task task : tasks) {
        task.setUser(user);
        boolean success = taskRepo.insertTask(task);
        if (!success) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
    return true;
}


}